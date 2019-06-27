package com.controller;


import com.db.tables.pojos.MUsers;
import com.interceptor.Auth;
import com.service.FileService;
import com.utils.AjaxJson;
import com.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    //@Auth
    @RequestMapping(value = "/init",method = RequestMethod.GET)
    public ModelAndView go(){
        return new ModelAndView("file");
    }


    //图片上传
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public AjaxJson fileUpload(@RequestParam("file") MultipartFile[] fileList, HttpSession session){
        AjaxJson ajaxJson = new AjaxJson();
        MUsers users = CommonUtil.getLoginUser(session);
        fileService.insertFile(fileList,"123");
        //System.out.println(fileList[0].getOriginalFilename()+"========");
        return ajaxJson;
    }


    //获取图片展示
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public AjaxJson getInfoFile(HttpServletRequest request){
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setObj(fileService.getFileInfo(request.getContextPath()));
        return ajaxJson;
    }


    //excel下载
    @RequestMapping(value="/excelDown",method = RequestMethod.POST)
    public String downloadExcel(){
        log.info("====================excel下载文件开始了=============================");
        fileService.downLoadExcel();
        return "";
    }

    //zip压缩包下载
    @RequestMapping(value="/zipDown",method = RequestMethod.POST)
    public String downloadZip(){
        log.info("====================zip下载文件开始了=============================");
        fileService.downloadZip();
        return "";
    }
}
