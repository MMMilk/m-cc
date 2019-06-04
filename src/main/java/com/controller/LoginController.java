package com.controller;


import com.db.tables.pojos.MUsers;
import com.service.LoginService;
import com.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/index",method =  RequestMethod.GET)
    public ModelAndView index(){
        return  new ModelAndView("login");
    }


    @RequestMapping(value = "/loginSubmit" ,method = RequestMethod.POST)
    public AjaxJson loginFlg(String username,String password,String authority){
        AjaxJson ajaxJson = new AjaxJson();
        int count = loginService.selectByUserName(username,password,authority);
        if(count == 1){
            ajaxJson.setMsg("success");
            return ajaxJson;
        }else{
            ajaxJson.setMsg("error");
            return ajaxJson;
        }

    }

    @RequestMapping(value = "/success",method =  RequestMethod.GET)
    public ModelAndView success(){
        return   new ModelAndView("success");
    }

    @RequestMapping(value = "/showInfo",method =  RequestMethod.GET)
    public MUsers showInfo(){
        MUsers users = new MUsers();
        users.setUsername("mmmilk");
        return  users;
    }

}
