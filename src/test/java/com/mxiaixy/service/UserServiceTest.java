package com.mxiaixy.service;

import com.mxiaixy.dao.UserDao;
import com.mxiaixy.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mxia on 2016/12/13.
 */
public class UserServiceTest {
    private UserService userService = new UserService();
    @Test
    public void findById() throws Exception {

       User user=  userService.findById(1);
       user =userService.findById(1);
       System.out.println(user);
    }
    @Test
    public void findAll(){
        List<User> userList = userService.findAll();
        Assert.assertEquals(1,userList.size());
    }

    @Test
    public void testSave(){
        List<User> userList = userService.findAll();
        int beforeList = userList.size();
        System.out.println(userList.size());

        User user = new User();
        user.setUsername("tom");
        user.setAge(30);
        user.setAddress("美国");
        user.setTel("343-454545");
        UserDao userDao = new UserDao();
        userDao.save(user);

        List<User> userList1 = userService.findAll();
        int afterList = userList1.size();
        Assert.assertEquals(beforeList+1,afterList);



    }



}