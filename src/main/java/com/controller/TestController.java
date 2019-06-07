package com.controller;

import com.db.tables.pojos.MUsers;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class TestController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/index11",method =  RequestMethod.GET)
    public int count(){
        int count = usersService.count();
        System.out.print("============="+count);
        return  1;
    }

    @RequestMapping(value = "/index21",method =  RequestMethod.GET)
    public String test(){
        int count = usersService.count();
        System.out.print("============="+count);
        return  "index";
    }

    @RequestMapping(value = "/index31",method =  RequestMethod.GET)
    public ModelAndView test3(){
        int count = usersService.count();
        System.out.print("============="+count);
        return  new ModelAndView("login");
    }

    @RequestMapping(value = "/index4",method =  RequestMethod.GET)
    public MUsers test4(){
        MUsers users = new MUsers();
       // users.setId(111);
        users.setPassword("1234556");
        users.setSex("boy");
        return  users;
    }


}
