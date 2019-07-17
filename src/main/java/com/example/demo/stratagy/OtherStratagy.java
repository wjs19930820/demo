package com.example.demo.stratagy;

import org.springframework.stereotype.Service;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/3/522:55
 */
@Service("Stratagy4")
public class OtherStratagy implements Stratagy{
    @Override
    public Double calCharge(Double charge) {
        return charge+charge*0.1;
    }
}
