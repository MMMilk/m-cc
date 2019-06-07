/*
 * This file is generated by jOOQ.
*/
package com.db.tables.records;


import com.db.tables.MUsers;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class MUsersRecord extends UpdatableRecordImpl<MUsersRecord> implements Record6<String, String, String, String, String, String> {

    private static final long serialVersionUID = -1120845021;

    /**
     * Setter for <code>milk.m_users.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>milk.m_users.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>milk.m_users.username</code>. 用户名（邮箱）
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>milk.m_users.username</code>. 用户名（邮箱）
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>milk.m_users.password</code>. 密码
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>milk.m_users.password</code>. 密码
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>milk.m_users.authority</code>. 权限身份
     */
    public void setAuthority(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>milk.m_users.authority</code>. 权限身份
     */
    public String getAuthority() {
        return (String) get(3);
    }

    /**
     * Setter for <code>milk.m_users.sex</code>. 性别
     */
    public void setSex(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>milk.m_users.sex</code>. 性别
     */
    public String getSex() {
        return (String) get(4);
    }

    /**
     * Setter for <code>milk.m_users.delete_flg</code>.
     */
    public void setDeleteFlg(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>milk.m_users.delete_flg</code>.
     */
    public String getDeleteFlg() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return MUsers.M_USERS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return MUsers.M_USERS.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return MUsers.M_USERS.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return MUsers.M_USERS.AUTHORITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return MUsers.M_USERS.SEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return MUsers.M_USERS.DELETE_FLG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAuthority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getSex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getDeleteFlg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MUsersRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MUsersRecord value2(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MUsersRecord value3(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MUsersRecord value4(String value) {
        setAuthority(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MUsersRecord value5(String value) {
        setSex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MUsersRecord value6(String value) {
        setDeleteFlg(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MUsersRecord values(String value1, String value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MUsersRecord
     */
    public MUsersRecord() {
        super(MUsers.M_USERS);
    }

    /**
     * Create a detached, initialised MUsersRecord
     */
    public MUsersRecord(String id, String username, String password, String authority, String sex, String deleteFlg) {
        super(MUsers.M_USERS);

        set(0, id);
        set(1, username);
        set(2, password);
        set(3, authority);
        set(4, sex);
        set(5, deleteFlg);
    }
}
