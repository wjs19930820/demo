package com.example.demo;

import org.junit.Test;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/2/210:48
 */
public class ThreadTest {

//    @Test
    public void test1(){
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("主线程结束");
    }

    public static void main1(String[] args) {
//        MyThread thread = new MyThread();
//        thread.start();
//        System.out.println("主线程结束");
    }
}

class MyThread extends Thread{
    private static int num = 0;

    public MyThread(){
        num++;
    }

    @Override
    public void run() {
        System.out.println("主动创建的第"+num+"个线程");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主动创建的第"+num+"个线程----结束");
    }
}