package com.utils;

import com.db.tables.pojos.MUsers;

import javax.servlet.http.HttpSession;
import java.util.UUID;

public class CommonUtil {

    /**
     * 获取当前登录的用户
     */
    public static MUsers getLoginUser(HttpSession session) {
        return (MUsers) session.getAttribute(ConstantUtil.LOGIN_USER);
    }

    /**
     * 更新当前登录的用户
     */
    public static void upDateLoginUser(HttpSession session, MUsers user) {
        session.setAttribute(ConstantUtil.LOGIN_USER, user);
    }

    public static String getUuid(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

}
