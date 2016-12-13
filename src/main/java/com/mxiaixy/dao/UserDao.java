package com.mxiaixy.dao;

import com.mxiaixy.entity.User;
import com.mxiaixy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;


/**
 * Created by Mxia on 2016/12/12.
 */
public class UserDao {

    public void save(User user){
        String sql = "insert into t_user(username,age,address,tel) values(?,?,?,?)";
        Dbhelp.update(sql,user.getUsername(),user.getAge(),user.getAddress(),user.getTel());

    }
    public User findById(Integer id){
        String sql ="select * from t_user where id = ?";
        return Dbhelp.query(sql,new BeanHandler<User>(User.class),id);
    }
    public List<User> findAll(){
        String sql = "select * from t_user";
        return Dbhelp.query(sql,new BeanListHandler<User>(User.class));
    }
}
