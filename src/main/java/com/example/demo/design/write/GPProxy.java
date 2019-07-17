package com.example.demo.design.write;

import java.lang.reflect.InvocationHandler;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/3/2714:41
 */
public class GPProxy {

    /**
     * @param loader  ClassLoader作用  动态生成Proxy0.class 并加载进虚拟机
     * @param interfaces
     * @param h
     * @return
     * @throws IllegalArgumentException
     */
    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h)
            throws IllegalArgumentException {
        return null;
    }
}
