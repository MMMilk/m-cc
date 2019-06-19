package com.service;



import com.db.tables.daos.MUsersDao;
import com.db.tables.pojos.MUsers;
import com.utils.ConstantUtil;
import com.utils.I18nUtil;
import com.view.UserInfoView;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.db.Tables.M_USERS;


@Service
public class UsersService {

    private DSLContext dslContext;
    private MUsersDao mUsersDao;
    private I18nUtil i18nUtil;

    @Autowired
    public UsersService(DSLContext dslContext,MUsersDao mUsersDao,I18nUtil i18nUtil){
        this.dslContext = dslContext;
        this.mUsersDao = mUsersDao;
        this.i18nUtil = i18nUtil;
    }

    public int count(){
       /* MUsers users = new MUsers();
        users.setId(2);
        users.setName("wu");
        users.setPassword("123456");
        mUsersDao.insert(users);*/
        int i = 1;
   /*   List<MUsers> list =  dslContext.select().from(M_USERS)
                .where(M_USERS.ID.eq(i))
                .fetch().into(MUsers.class);*/

        return i;
    }


    public List<UserInfoView>  getInfo(int pageSize,int pageNum){
        List<UserInfoView> list = dslContext.select().from(M_USERS)
                .where(M_USERS.DELETE_FLG.eq(ConstantUtil.TABLE_DELETE_FLG_FALSE))
                .orderBy(M_USERS.ID.asc())
                .limit(pageSize)
                .offset((pageNum -1)*pageSize)
                .fetch()
                .map(v ->
                        new UserInfoView(
                                v.getValue(M_USERS.ID),
                                v.getValue(M_USERS.USERNAME),
                                v.getValue(M_USERS.PASSWORD),
                                v.getValue(M_USERS.AUTHORITY).equals(ConstantUtil.TABLE_DELETE_FLG_FALSE)? i18nUtil.getMsg(ConstantUtil.USER01):i18nUtil.getMsg(ConstantUtil.USER02),
                                v.getValue(M_USERS.SEX).equals(ConstantUtil.TABLE_DELETE_FLG_FALSE)? i18nUtil.getMsg(ConstantUtil.SEX01):i18nUtil.getMsg(ConstantUtil.SEX02)
                        )
                );
        return  list;
    }
}
