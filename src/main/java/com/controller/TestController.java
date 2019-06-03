package com.controller;

import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/index",method =  RequestMethod.GET)
    public int count(){
        int count = usersService.count();
        System.out.print("============="+count);
        return  1;
    }


}
