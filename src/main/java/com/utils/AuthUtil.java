package com.utils;

import com.db.tables.pojos.MUsers;
import com.interceptor.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Slf4j
public class AuthUtil implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        log.info("======================是否登录验证开始===============");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(Auth.class)){
          HttpSession session = httpServletRequest.getSession();
          MUsers users = CommonUtil.getLoginUser(session);
          if(users == null){
              httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/index");
              return false;
          }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
