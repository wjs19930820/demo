package com.example.demo.design.write;

import com.example.demo.design.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/3/2715:54
 */
//public class GPMeiPo implements GPInvocationHandler {
public class GPMeiPo implements InvocationHandler {

    private Person target;

    //获取被代理人的个人资料
    //此方法为声场代理对象的方法  代理对象会自动调用invoke方法
    public Object getInstance(Person target){
        this.target = target;
        Class<? extends Person> clazz = target.getClass();
        System.out.println("被代理对象的class" + clazz);
//        Proxy.newProxyInstance()
//        return GPProxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
