package com.service;

import com.db.tables.daos.MFilesDao;
import com.db.tables.pojos.MFiles;
import com.utils.CommonUtil;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final DSLContext  dslContext;

    private final MFilesDao mFilesDao;

    private final String  File_Path = "/file";

    @Autowired
    public FileService(DSLContext  dslContext,MFilesDao mFilesDao){
        this.dslContext = dslContext;
        this.mFilesDao = mFilesDao;
    }

    public boolean insertFile( MultipartFile[] fileList,String username){
        for(MultipartFile file : fileList){
            MFiles mFiles = new MFiles();
            mFiles.setId(CommonUtil.getUuid());
            mFiles.setFileUrl(File_Path+"?+");
            mFiles.setFileName(file.getName());
            mFilesDao.insert(mFiles);
        }
        return true;
    }


}
