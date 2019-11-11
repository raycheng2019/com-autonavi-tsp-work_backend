/**
 * autonavi.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.autonavi.tsp.test;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * Created by you on 2019-11-11.
 */
public class BaseTest {

    public final static String BASEURL = "http://localhost:8080/mc_web/hessian/";

    public HessianProxyFactory getFactory(){
        // 创建factory实例
        HessianProxyFactory factory = new HessianProxyFactory();
        factory.setOverloadEnabled(true); //启用方法重载识别
        return factory;
    }
}