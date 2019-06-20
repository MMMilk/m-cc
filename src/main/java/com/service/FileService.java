package com.service;

import com.db.tables.daos.MFilesDao;
import com.db.tables.pojos.MFiles;
import com.utils.CommonUtil;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

@Service
@Component
public class FileService {

    private final DSLContext  dslContext;

    private final MFilesDao mFilesDao;


    @Value("${c_milk.base-upload-path}")
    private String path;

    @Autowired
    public FileService(DSLContext  dslContext,MFilesDao mFilesDao){
        this.dslContext = dslContext;
        this.mFilesDao = mFilesDao;
    }

    public boolean insertFile( MultipartFile[] fileList,String username){
        for(MultipartFile file : fileList){
            LocalDateTime now =  LocalDateTime.now();
            MFiles mFiles = new MFiles();
            mFiles.setId(CommonUtil.getUuid());
            mFiles.setFileName(file.getOriginalFilename());
            mFiles.setFileUrl(path+"/"+CommonUtil.getUrl(now)+"/"+CommonUtil.getFileName(now));
            mFiles.setUsername(username);
            mFilesDao.insert(mFiles);
            CommonUtil.saveFile(path,file,now);
        }
        return true;
    }


}
