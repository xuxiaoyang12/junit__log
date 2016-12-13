package com.mxiaixy.dao;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mxia on 2016/12/12.
 */
public class Log4jTestCase {
    @Test
    public void testLog(){
        //Logger logger = Logger.getLogger(Log4jTestCase.class);//普通log4j
        //Logger logger = LoggerFactory.getLogger(Log4jTestCase.class);//使用slf4j 适配器模式  如果改变安全日志的方式只需改变底层配置就行无需改变代码
        Logger logger  = LoggerFactory.getLogger(Log4jTestCase.class);

        logger.trace("{}trace message","tom");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        //logger.fatal("fatal message");//slf4j中不存在fatal这个标签
    }
}
