package com.utils;

import com.db.tables.pojos.MUsers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class CommonUtil {


    /**
     * 获取当前登录的用户
     */
    public static MUsers getLoginUser(HttpSession session) {
        return (MUsers) session.getAttribute(ConstantUtil.LOGIN_USER);
    }

    /**
     * 更新当前登录的用户
     */
    public static void upDateLoginUser(HttpSession session, MUsers user) {
        session.setAttribute(ConstantUtil.LOGIN_USER, user);
    }

    public static String getUuid(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    //生成上次文件的URL
    public static String getUrl(LocalDateTime now){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        return format.format(LocalDateTime.now());
    }


    //生成上次文件的新名字
    public static String getFileName(LocalDateTime now){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String name = format.format(now)+"-"+(Math.random()*9+1)*1000000000;
        return format.format(LocalDateTime.now());
    }

    //保存上次文件到本地
    public static void saveFile(String path,MultipartFile multipartFile,LocalDateTime now){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        File  file = new File(path+"/"+format.format(now)+"/"+getFileName(now));
        if(!file.exists()){
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getPath()+"/"+multipartFile.getOriginalFilename());
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
