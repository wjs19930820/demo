package com.example.demo.stratagy;

import org.springframework.stereotype.Service;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/3/522:55
 */
@Service("Stratagy1")
public class CashStratagy implements Stratagy{
    @Override
    public Double calCharge(Double charge) {
        return charge*1;
    }
}
