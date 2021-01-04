package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 包名:com.itheima.utils
 *
 * @author Leevi
 * 日期2020-12-12  11:40
 */
public class SqlSessionFactoryUtil {
    public static SqlSessionFactory sqlSessionFactory;
    private static InputStream is;
    static {
        try {
            //1. 加载核心配置文件
            //1.1 将核心配置文件转换成字节输入流
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //1.2 创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //1.3 使用builder对象，加载流，构建SqlSessionFactory
            sqlSessionFactory = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建SqlSession
     * @return
     */
    public static SqlSession openSqlSession() throws IOException {
        try {
            return sqlSessionFactory.openSession();
        } finally {
            is.close();
        }
    }

    /**
     * 提交事务并且关闭资源
     */
    public static void commitAndClose(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 回滚事务并且关闭资源
     * @param sqlSession
     */
    public static void rollbackAndClose(SqlSession sqlSession){
        sqlSession.rollback();
        sqlSession.close();
    }
}
