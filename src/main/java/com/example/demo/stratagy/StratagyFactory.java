package com.example.demo.stratagy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/3/523:02
 */
public class StratagyFactory {

    private static StratagyFactory stratagyFactory = new StratagyFactory();

    private StratagyFactory(){};

    private static Map stratagyMap = new HashMap();

    static {
        stratagyMap.put(RechargeTypeEnum.CASH.getCode(), new CashStratagy());
        stratagyMap.put(RechargeTypeEnum.BANK.getCode(), new BankStratagy());
        stratagyMap.put(RechargeTypeEnum.MOBILE.getCode(), new MobileStratagy());
        stratagyMap.put(RechargeTypeEnum.OTHER.getCode(), new OtherStratagy());
    }

    public Stratagy creator(int type){
        return (Stratagy) stratagyMap.get(type);
    }

    public static StratagyFactory getInstance(){
        return stratagyFactory;
    }
}
