package com.mxiaixy.dao;

import net.sf.ehcache.Cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.junit.Test;

/**
 * Created by Mxia on 2016/12/13.
 *
 * 缓存 ehcache 的基本应用
 */
public class CacheTestCase {
    @Test
    public void testCache(){
        CacheManager cacheManager = new CacheManager();//获取xml
        Ehcache ehcache = cacheManager.getEhcache("user");//执行xml

        //添加
        Element element = new Element("user:1","jack");//添加键值对到元素
        ehcache.put(element);//把元素添加到缓存区

        //取值
        Element element1 = ehcache.get("user:1");//通过键获取元素
        System.out.println(element1.getObjectValue());//通过getObjectValue方法来获取值
        //删除
        //ehcache.removeAll();//删除缓存所有数据
        //ehcache.remove("user:1");//删除缓存中指定的元素

    }
}
