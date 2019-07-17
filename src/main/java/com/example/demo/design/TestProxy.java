package com.example.demo.design;

import com.example.demo.design.write.GPMeiPo;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/1/3118:18
 */
public class TestProxy {

    public static void main(String[] args) {
        /*Person instance = (Person)new MeiPo().getInstance(new XiaoXingXing());
        System.out.println(instance.getClass());
        instance.happy();
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{instance.getClass()});
        try {
            FileOutputStream os = new FileOutputStream("E:/$Proxy0.class");
            os.write(data);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Person instance = (Person)new MeiPo().getInstance(new XiaoXingXing());
        System.out.println(instance.getClass());
        instance.happy();
    }
}
