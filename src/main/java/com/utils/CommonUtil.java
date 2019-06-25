package com.utils;

import com.db.tables.pojos.MUsers;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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


    //生成上次文件的二级path
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



    //MD05加密
    public static String getMD5(String str){
        try {
            MessageDigest messageDigest =  MessageDigest.getInstance("MD5");
            byte[] b = messageDigest.digest(str.getBytes("UTF-8"));
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


}
