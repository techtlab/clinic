package com.clinic.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class MyBatisUtil {

    private static SqlSessionFactory factory;
    private static Properties properties;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/clinic";
    private static String userName = "root";
    private static String password = "root";

    public MyBatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        Reader reader = null;
        properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("username", userName);
        properties.setProperty("password", password);
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader, properties);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return factory;
    }
}
