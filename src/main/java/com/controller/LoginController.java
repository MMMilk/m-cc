package com.controller;


import com.db.tables.pojos.MUsers;
import com.service.LoginService;
import com.utils.AjaxJson;
import com.utils.CommonUtil;
import com.utils.ConstantUtil;
import com.utils.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private EmailUtil emailUtil;


    //跳转登录页面
    @RequestMapping(value = "/index",method =  RequestMethod.GET)
    public ModelAndView index(){
        //log.info("1233333333333333333333333333");
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


    //跳转注册页面
    @RequestMapping(value = "/register",method =  RequestMethod.GET)
    public ModelAndView register(){
        return  new ModelAndView("register");
    }


    //发送邮箱验证码
    @RequestMapping(value = "/getEmail",method =  RequestMethod.POST)
    public void getEmail(String email,HttpSession session){
        int code = (int) ((Math.random()*9+1)*100000);
        emailUtil.sendEmail(email,code);
        session.setAttribute("code",code);
        session.setAttribute("eamil",email);

    }

    //判断邮箱验证码是否正确
    @RequestMapping(value = "/registered",method =  RequestMethod.POST)
    public AjaxJson registered(String email,String code,String password,HttpSession session){
        AjaxJson ajaxJson = new AjaxJson();

        String emailY = session.getAttribute("eamil").toString();
        if(email.equals(emailY)){
            if(code.equals(session.getAttribute("code").toString())){
                loginService.registered(email,password);
                ajaxJson.setMsg(ConstantUtil.SUCCESS);
                session.removeAttribute("eamil");
                session.removeAttribute("code");
            }else {
                ajaxJson.setMsg(ConstantUtil.PASS_ERROR);
            }
        }else {
            ajaxJson.setMsg("输入的邮箱两次不一样");
        }
        return  ajaxJson;
    }






}
