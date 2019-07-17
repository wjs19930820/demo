package com.example.demo.design;

import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/1/3117:50
 */
public class MeiPo implements InvocationHandler {

    private Person target;

    //获取被代理人的个人资料
    //此方法为声场代理对象的方法  代理对象会自动调用invoke方法
    public Object getInstance(Person target){
        this.target = target;
        Class<? extends Person> clazz = target.getClass();
        System.out.println("被代理对象的class" + clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("媒婆来帮你找对象：您的姓名是" + target.getName() + "，你的性别是" + target.getSex());
        System.out.println("开始海选---------------------");
        method.invoke(target,args);
        System.out.println("----------------------");
        System.out.println("你已经有对象 告辞~");

        return null;
    }
}
