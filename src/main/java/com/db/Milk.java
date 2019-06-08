/*
 * This file is generated by jOOQ.
*/
package com.db;


import com.db.tables.MUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Milk extends SchemaImpl {

    private static final long serialVersionUID = 483729025;

    /**
     * The reference instance of <code>milk</code>
     */
    public static final Milk MILK = new Milk();

    /**
     * The table <code>milk.m_users</code>.
     */
    public final MUsers M_USERS = com.db.tables.MUsers.M_USERS;

    /**
     * No further instances allowed
     */
    private Milk() {
        super("milk", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            MUsers.M_USERS);
    }
}