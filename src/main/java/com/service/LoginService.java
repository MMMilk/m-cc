package com.service;

import com.db.tables.daos.MUsersDao;
import com.db.tables.pojos.MUsers;
import com.utils.ConstantUtil;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.db.Tables.M_USERS;

@Service
public class LoginService {

    private DSLContext dslContext;
    private MUsersDao mUsersDao;

    @Autowired
    public LoginService(DSLContext dslContext,MUsersDao mUsersDao){
        this.dslContext = dslContext;
        this.mUsersDao = mUsersDao;
    }

    //根据用户名,密码，权限查询记录
    public int selectByUserName(String userName,String password,String authority){
        Condition condition = M_USERS.DELETE_FLG.eq(ConstantUtil.TABLE_DELETE_FLG_FALSE);
        if(!StringUtils.isEmpty(userName)){
            condition = condition.and(M_USERS.USERNAME.eq(userName));
        }
        if(!StringUtils.isEmpty(password)){
            condition = condition.and(M_USERS.PASSWORD.eq(password));
        }
        if(!StringUtils.isEmpty(authority)){
            condition = condition.and(M_USERS.AUTHORITY.eq(authority));
        }
        int count = dslContext.selectCount().from(M_USERS)
                .where(condition)
                .fetchOne().value1();
        return  count > 0 ? count : 0;

    }

}
