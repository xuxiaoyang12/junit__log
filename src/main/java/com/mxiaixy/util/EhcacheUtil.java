package com.mxiaixy.util;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.ObjectExistsException;

import java.io.Serializable;

/**
 * 缓存 工具类
 * Created by Mxia on 2016/12/13.
 */
public class EhcacheUtil {

    //为了使代码变得更简洁 更具有条理性 可修改行更强  故增加工具类一实现
    //private static final String CACHE_USER_NAME="user";//
    private CacheManager cacheManager = new CacheManager();//限制其只能被穿件一次

    /**
     * 获取缓存 Ehcache 对象
     * @return Encache对象
     */
    public Ehcache getEhcache(String cacheName){
        return cacheManager.getEhcache(cacheName);
    }
    //添加
    public void save(Ehcache ehcache, Serializable key, Serializable value){
        Element element = new Element(key,value);
        ehcache.put(element);
    }
    public void save(String cacheName,Serializable key,Serializable value){
        Ehcache ehcache = getEhcache(cacheName);
        Element element = new Element(key,value);
        ehcache.put(element);
    }
    public void save(String cacheName,Object key,Object value){
        Ehcache ehcache = getEhcache(cacheName);
        Element element = new Element(key,value);
        ehcache.put(element);
    }

    //查询

    public Object find(String cacheName,Serializable key){
            Ehcache ehcache = getEhcache(cacheName);
            Element element = ehcache.get(key);
            return element==null? null:element.getObjectValue();
    }
    public Object find(Ehcache ehcache,Serializable key){
        Element element = ehcache.get(key);
        return element==null? null:element.getObjectValue();
    }
    public Object find(Ehcache ehcache,Object key){
        Element element = ehcache.get(key);
        return element==null? null:element.getObjectValue();
    }
    //通过key删除
    public void del(String cacheName,Serializable key){
        getEhcache(cacheName).remove(key);
    }
    public void del(Ehcache ehcache , Serializable key){
        ehcache.remove(key);
    }
    //删除全部
    public void delAll(String cacheName){
        getEhcache(cacheName).removeAll();
    }
    public void delAll(Ehcache ehcache){
        ehcache.removeAll();
    }

}
