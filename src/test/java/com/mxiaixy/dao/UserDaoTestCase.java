package com.mxiaixy.dao;

import com.mxiaixy.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;//静态导入


/**
 * Created by Mxia on 2016/12/12.
 */
public class UserDaoTestCase {
    @Test
    public void testSave(){
        UserDao userDao = new UserDao();
        User user = new User();

        user.setUsername("tom");
        user.setAge(34);
        user.setAddress("美国");
        user.setTel("34-343434");

        userDao.save(user);
    }
    @Test
    public void testFindById(){
        UserDao userDao = new UserDao();
        User user = new User();

        userDao.findById(1);
        assertNotNull(user);
    }
    @Test
    public void testFindAll(){
        UserDao userDao = new UserDao();
        List<User> userList = userDao.findAll();

        assertEquals(2,userList.size());
    }
}
