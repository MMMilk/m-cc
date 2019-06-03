package com.service;


import com.db.tables.daos.UsersDao;
import com.db.tables.pojos.Users;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.db.tables.Users.*;


@Service
public class UsersService {

    private DSLContext dslContext;
    private UsersDao usersDao;

    @Autowired
    public UsersService(DSLContext dslContext,UsersDao usersDao){
        this.dslContext = dslContext;
        this.usersDao = usersDao;
    }

    public int count(){
        Users users = new Users();
        users.setId(2);
        users.setName("wu");
        users.setPassword("123456");
        usersDao.insert(users);
        int i = 1;
      List<Users> list =  dslContext.select().from(USERS)
                .where(USERS.ID.eq(i))
                .fetch().into(Users.class);

        return list.size();
    }

}
