package com.example.demo.design;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/1/3117:38
 */
public class XiaoXingXing implements Person {

    private String sex = "女";

    private String name = "小星星";

    @Override
    public void findLove() {
        System.out.println("找个富帅");
        System.out.println("现在这个就挺好");
    }

    @Override
    public void happy() {
        System.out.println("现在很happy");
        System.out.println("实现财富自由~");
    }

    @Override
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
