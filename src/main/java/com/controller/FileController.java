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


    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public AjaxJson getInfoFile(HttpServletRequest request){
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setObj(fileService.getFileInfo(request.getContextPath()));
        return ajaxJson;
    }


    @RequestMapping(value="/excelDown",method = RequestMethod.POST)
    public String download(){
        log.info("====================下载文件开始了=============================");
        fileService.downLoad();
        return "";
    }
}
