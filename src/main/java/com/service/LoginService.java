package com.service;

import com.db.tables.daos.MUsersDao;
import com.db.tables.pojos.MUsers;
import com.utils.CommonUtil;
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

    //根据用户名,密码查询记录
    public String selectByUserName(String userName,String password){
        Condition condition = M_USERS.DELETE_FLG.eq(ConstantUtil.TABLE_DELETE_FLG_FALSE);
        if(!StringUtils.isEmpty(userName)){
            condition = condition.and(M_USERS.USERNAME.eq(userName));
        }

        int countForName = dslContext.selectCount().from(M_USERS)
                .where(condition)
                .fetchOne().value1();
        if(countForName > 0){
            if(!StringUtils.isEmpty(password)){
                condition = condition.and(M_USERS.PASSWORD.eq(password));
            }
            int countForPass = dslContext.selectCount().from(M_USERS)
                    .where(condition)
                    .fetchOne().value1();
            if(countForPass > 0){
                return ConstantUtil.SUCCESS;
            }
            return ConstantUtil.PASS_ERROR;
        }
        return ConstantUtil.USERS_ERROR;
    }

    //获取的登录的用户对象
    public MUsers selectUser(String userName, String password){
        Condition condition = M_USERS.DELETE_FLG.eq(ConstantUtil.TABLE_DELETE_FLG_FALSE).and(M_USERS.USERNAME.eq(userName)).and(M_USERS.USERNAME.eq(userName));
        return dslContext.select().from(M_USERS)
                .where(condition)
                .fetchOne().into(MUsers.class);
    }

    public void registered(String eamil,String password){
        MUsers users = new MUsers();
        users.setId(CommonUtil.getUuid());
        users.setUsername(eamil);
        users.setPassword(password);
        users.setSex("boy");
        users.setDeleteFlg(ConstantUtil.TABLE_DELETE_FLG_FALSE);
        users.setAuthority(ConstantUtil.TABLE_DELETE_FLG_FALSE);
        mUsersDao.insert(users);
    }

}
