package com.example.demo.stratagy;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/3/523:25
 */
public class Context {

    public Double callCharge(Double charge, int type){
//        Stratagy stratagy = StratagyFactory.getInstance();
        return StratagyFactory.getInstance().creator(type).calCharge(charge);
    }

}
