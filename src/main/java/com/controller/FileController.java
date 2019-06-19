package com.controller;


import com.db.tables.pojos.MUsers;
import com.service.FileService;
import com.utils.AjaxJson;
import com.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

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
        //fileService.insertFile(fileList,users.getUsername());
        System.out.println(fileList[0].getOriginalFilename()+"========");
        return ajaxJson;
    }
}
