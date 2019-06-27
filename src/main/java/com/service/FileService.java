package com.service;

import com.db.tables.daos.MFilesDao;
import com.db.tables.pojos.MFiles;
import com.utils.CommonUtil;
import com.view.FileInfoView;
import org.apache.poi.hssf.usermodel.*;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

import static com.db.tables.MFiles.M_FILES;

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
        LocalDateTime now =  LocalDateTime.now();
        for(MultipartFile file : fileList){
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

    public List<FileInfoView> getFileInfo(String context){
        return dslContext.select().from(M_FILES)
                .fetch()
                .map(v->
                        new FileInfoView(
                                v.getValue(M_FILES.FILE_NAME),
                                v.getValue(M_FILES.FILE_URL)+"/"+ v.getValue(M_FILES.FILE_NAME),
                                v.getValue(M_FILES.USERNAME)
                        )

                );
    }


    //下载excel文档
    public void  downLoad(){
        File file = new File("milkExcel.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建一个sheet
        HSSFSheet sheet = hssfWorkbook.createSheet("sheet_01");
        //设置sheet的字体样式
        HSSFFont font = hssfWorkbook.createFont();
        font.setColor(HSSFFont.COLOR_RED);

        //创建行
        HSSFRow row = sheet.createRow(0);
        //创建单元格
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("milk");

        try {
            FileOutputStream fileInputStream = new FileOutputStream(file);
            hssfWorkbook.write(fileInputStream);
            fileInputStream.close();
            System.out.println("xxxxxxxxxxxxxxxxxxxx"+file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
