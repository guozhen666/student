package com.pag.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class Jdbctool {
    static ComboPooledDataSource ds = new ComboPooledDataSource();
    //创建QueryRunner对象
    static QueryRunner qr=new QueryRunner(ds);
    public static QueryRunner getQueryRunner(){
        return qr;
    }
}

