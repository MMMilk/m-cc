package com.service;



import com.db.tables.daos.MUsersDao;
import com.db.tables.pojos.MUsers;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.db.Tables.M_USERS;


@Service
public class UsersService {

    private DSLContext dslContext;
    private MUsersDao mUsersDao;

    @Autowired
    public UsersService(DSLContext dslContext,MUsersDao mUsersDao){
        this.dslContext = dslContext;
        this.mUsersDao = mUsersDao;
    }

    public int count(){
       /* MUsers users = new MUsers();
        users.setId(2);
        users.setName("wu");
        users.setPassword("123456");
        mUsersDao.insert(users);*/
        int i = 1;
      List<MUsers> list =  dslContext.select().from(M_USERS)
                .where(M_USERS.ID.eq(i))
                .fetch().into(MUsers.class);

        return list.size();
    }

}
