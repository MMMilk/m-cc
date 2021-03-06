/*
 * This file is generated by jOOQ.
*/
package com.db.tables;


import com.db.Keys;
import com.db.Milk;
import com.db.tables.records.MUsersRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MUsers extends TableImpl<MUsersRecord> {

    private static final long serialVersionUID = -181144486;

    /**
     * The reference instance of <code>milk.m_users</code>
     */
    public static final MUsers M_USERS = new MUsers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MUsersRecord> getRecordType() {
        return MUsersRecord.class;
    }

    /**
     * The column <code>milk.m_users.id</code>.
     */
    public final TableField<MUsersRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "");

    /**
     * The column <code>milk.m_users.username</code>. 姓名
     */
    public final TableField<MUsersRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "姓名");

    /**
     * The column <code>milk.m_users.password</code>. 密码
     */
    public final TableField<MUsersRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "密码");

    /**
     * The column <code>milk.m_users.authority</code>. 权限
     */
    public final TableField<MUsersRecord, String> AUTHORITY = createField("authority", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "权限");

    /**
     * The column <code>milk.m_users.sex</code>. 性别
     */
    public final TableField<MUsersRecord, String> SEX = createField("sex", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "性别");

    /**
     * The column <code>milk.m_users.delete_flg</code>.
     */
    public final TableField<MUsersRecord, String> DELETE_FLG = createField("delete_flg", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * Create a <code>milk.m_users</code> table reference
     */
    public MUsers() {
        this("m_users", null);
    }

    /**
     * Create an aliased <code>milk.m_users</code> table reference
     */
    public MUsers(String alias) {
        this(alias, M_USERS);
    }

    private MUsers(String alias, Table<MUsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private MUsers(String alias, Table<MUsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Milk.MILK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MUsersRecord> getPrimaryKey() {
        return Keys.KEY_M_USERS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MUsersRecord>> getKeys() {
        return Arrays.<UniqueKey<MUsersRecord>>asList(Keys.KEY_M_USERS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MUsers as(String alias) {
        return new MUsers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MUsers rename(String name) {
        return new MUsers(name, null);
    }
}
