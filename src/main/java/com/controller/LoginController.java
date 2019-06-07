package com.controller;


import com.db.tables.pojos.MUsers;
import com.service.LoginService;
import com.utils.AjaxJson;
import com.utils.CommonUtil;
import com.utils.ConstantUtil;
import com.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private EmailUtil emailUtil;

    //跳转登录页面
    @RequestMapping(value = "/index",method =  RequestMethod.GET)
    public ModelAndView index(){
        return  new ModelAndView("login");
    }


    //判断登录
    @RequestMapping(value = "/loginSubmit" ,method = RequestMethod.POST)
    public AjaxJson loginFlg(String username, String password,HttpSession session){
        AjaxJson ajaxJson = new AjaxJson();
        String result = loginService.selectByUserName(username,password);
        ajaxJson.setMsg(result);
        if(result.equals(ConstantUtil.SUCCESS)) {
            CommonUtil.upDateLoginUser(session,loginService.selectUser(username,password));
        }
        return ajaxJson;
    }

    //登录跳转成功页面
    @RequestMapping(value = "/success",method =  RequestMethod.GET)
    public ModelAndView success(){
        return   new ModelAndView("success");
    }

    //获取登录的用户名
    @RequestMapping(value = "/showInfo",method =  RequestMethod.GET)
    public MUsers showInfo(HttpSession session){
        MUsers users = CommonUtil.getLoginUser(session);
        return  users;
    }


    //跳转登录页面
    @RequestMapping(value = "/register",method =  RequestMethod.GET)
    public ModelAndView register(){
        return  new ModelAndView("register");
    }


    //跳转登录页面
    @RequestMapping(value = "/getEmail",method =  RequestMethod.POST)
    public void getEmail(String email,HttpSession session){
        int code = (int) ((Math.random()*9+1)*100000);
        emailUtil.sendEmail(email,code);
        session.setAttribute("code",code);
        session.setAttribute("eamil",email);

    }

    @RequestMapping(value = "/registered",method =  RequestMethod.POST)
    public AjaxJson registered(String code,String password,HttpSession session){
        AjaxJson ajaxJson = new AjaxJson();
        String email = session.getAttribute("eamil").toString();
        if(code.equals(session.getAttribute("code").toString())){
            loginService.registered(email,password);
            ajaxJson.setMsg(ConstantUtil.SUCCESS);
        }else {
            ajaxJson.setMsg(ConstantUtil.PASS_ERROR);
        }
        session.removeAttribute("eamil");
        return  ajaxJson;
    }






}
