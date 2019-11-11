/**
 * autonavi.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.autonavi.tsp.common.util;

import org.apache.log4j.Logger;

/**
 * Created by you on 2014/12/3.
 */
public class McLog {
    private static Logger logger = Logger.getLogger(McLog.class);

    public static Logger getLogger(){
        return logger;
    }
    /**
     * 控制台输
     */
    public static void console(String message) {
        System.out.println(message);
    }

    /**
     * 普通日志־
     */
    public static void info(String message, boolean isSave) {
        logger.info(message);
    }

    /**
     * 错误日志־
     */
    public static void error(String message, Throwable ex, boolean isSave) {
        logger.error(message, ex);
    }

    /**
     * 错误日志־
     */
    public static void error(String message, boolean isSave) {
        logger.error(message);
    }

    /**
     * 调试日志־
     */
    public static void debug(String message) {
        logger.debug(message);
    }

    /**
     * 警告日志־
     */
    public static void warn(String message, boolean isSave) {
        logger.warn(message);
    }
}