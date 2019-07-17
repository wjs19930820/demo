package com.example.demo.design.write;

import java.lang.reflect.Method;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/3/2714:39
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
