package com.gugu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlsesionUtil {

    private  static SqlSessionFactory factory;

    static {
        InputStream input = null;
        try {
            input = Resources.getResourceAsStream("mybatis.xml");
             factory= new SqlSessionFactoryBuilder().build(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获得sqlsession 的实现
    public static SqlSession   getSqlSession(){

        return   factory.openSession(true);
    }

}
