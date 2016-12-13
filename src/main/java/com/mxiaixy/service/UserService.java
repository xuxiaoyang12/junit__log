package com.mxiaixy.service;

import com.mxiaixy.dao.UserDao;
import com.mxiaixy.entity.User;
import com.mxiaixy.util.EhcacheUtil;
import net.sf.ehcache.Ehcache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * 服务逻辑类
 * Created by Mxia on 2016/12/13.
 */

public class UserService {

    private UserDao userDao = new UserDao();
    private EhcacheUtil ehcacheUtil = new EhcacheUtil();
    private static final String USER_CACHE_NAME="user";
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public User findById(Integer id){
        //通过缓存查询是否存在
        //Ehcache ehcache = ehcacheUtil.getEhcache(USER_CACHE_NAME);//获取缓存对象
        //查询是否存在
        User user = (User)ehcacheUtil.find(USER_CACHE_NAME,"user:"+id);
        System.out.println(user);
        if(user==null){
            //查询数据库
           user = userDao.findById(id);
            //把数据添加进缓存
           ehcacheUtil.save(USER_CACHE_NAME,"user:"+id,user);
        }
        return user;
    }

    public List<User> findAll() {
        List<User> userList = (List<User>) ehcacheUtil.find(USER_CACHE_NAME,"userList");
        if(userList==null){
            userList = userDao.findAll();
            //添加到缓冲区
            ehcacheUtil.save(USER_CACHE_NAME,"userlist",userList);
        }
        return userList;
    }
    //当数据库发生修改时要适当秦楚缓存中的相关数据已达到 同步性
    public void delById(Integer id){
        userDao.delById(id);
        ehcacheUtil.del(USER_CACHE_NAME,"user:"+id);

    }
    public void save(User user){
        userDao.save(user);
        ehcacheUtil.delAll(USER_CACHE_NAME);
    }
}
