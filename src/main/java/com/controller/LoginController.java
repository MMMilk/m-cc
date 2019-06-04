package com.controller;


import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/loginSubmit" ,method = RequestMethod.POST)
    public String loginFlg(String username,String password,String authority){
        String aa = "success";
        int count = loginService.selectByUserName(username,password,authority);
        if(count == 1){
            return aa;
        }else{
            return aa;
        }

    }

}
