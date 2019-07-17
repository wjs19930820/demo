package com.example.demo;

import org.junit.runner.Result;

import java.util.function.Supplier;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/1/2416:14
 */
public class BaseServiceUtils {

    public static<R> R doFind(Supplier supplier, int count) throws Exception {

        for (int i = 0; i < count; i++) {
            Object o = supplier.get();
            if (o instanceof Result){
                Result result = (Result)o;
                return (R) result;
            } else {
                if (o != null){
                    return (R) o;
                }
            }

        }
        throw new Exception("111");
    }
}
