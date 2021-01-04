package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * 包名:com.itheima
 * @author Leevi
 * 日期2020-12-13  08:46
 */
public class TestMybatis {
    @Test
    public void test01() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findByUid(1);
        System.out.println(user);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
