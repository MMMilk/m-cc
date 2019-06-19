package com.controller;

import com.service.UsersService;
import com.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/page")
public class PageController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/goPage",method = RequestMethod.GET)
    public ModelAndView goPage(){
        return new ModelAndView("page");
    }


    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public AjaxJson getInfo(int pageSize,int pageNum){
        AjaxJson ajaxJson = new AjaxJson();
        //ajaxJson.setObj(usersService.getInfo(pageSize,pageNum));
        ajaxJson.setPageInfo(6,2,2,3,usersService.getInfo(pageSize,pageNum));
        return ajaxJson;
    }



}
