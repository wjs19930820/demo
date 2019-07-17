package com.example.demo.controller;

import com.example.demo.domain.Review;
import com.example.demo.stratagy.Context;
import com.example.demo.stratagy.RechargeTypeEnum;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/11/1917:25
 */
@RestController
public class HelloController {

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
//    @ApiImplicitParam(name = "str",paramType = "query", value = "输入字符串", required = true, dataType = "String")
//    @Scheduled(fixedRate = 5000)
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello");
        return "Hello World";
    }

    public static void main1(String[] args) throws ParseException {

        String errorMsg = "21341234123";
        /*for (int i = 0;i < 200 ; i++) {
            errorMsg += i + "_";
        }*/
        if (errorMsg.length() > 400) {
            errorMsg = errorMsg.substring(0, 400);
        }
        System.out.println(errorMsg);
        System.out.println(errorMsg.length());
//        SimpleDateFormat dateFormat;
//        String deliveryDateForShow = "2019/01/01";
//        if (deliveryDateForShow.indexOf("-") != -1) {
//            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        } else {
//            dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        }
//        Date deliveryDateForShowFirst = dateFormat.parse(deliveryDateForShow);
//        System.out.println(deliveryDateForShowFirst);
        /*List<Date> deliveryDateList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2019-01-01");
        Date date2 = dateFormat.parse("2019-06-29");
        Date date3 = dateFormat.parse("2019-07-02");
        Date date4 = dateFormat.parse("2019-07-06");
        deliveryDateList.add(date1);
        deliveryDateList.add(date2);
        deliveryDateList.add(date3);
        System.out.println(deliveryDateList.contains(date4));
        deliveryDateList.add(date4);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date initDate = calendar.getTime();
        calendar.add(Calendar.DATE, 7);
        Date maxTime = calendar.getTime();
        Iterator<Date> iterator = deliveryDateList.iterator();
        while (iterator.hasNext()) {
            Date date = iterator.next();
            if (date.before(initDate)  || date.after(maxTime)) {
                iterator.remove();
            }
        }
        System.out.println(deliveryDateList);*/
    }

/*    public static void main(String[] args) throws InterruptedException {
        final ConcurrentHashMap<Integer, Set> chm = new ConcurrentHashMap<Integer, Set>();
        List<Integer> list = new ArrayList();
        Set<Integer> list2 = new HashSet<>();
        for (int i = 0;i < 10000 ;i++){
            list.add(i);
        }
        list.parallelStream().forEach(i -> {
            list2.add(i);
        });
        System.out.println(list2.size());
    }*/

   /* public static void main(String[] args) throws InterruptedException {
        final ConcurrentHashMap<Integer, Set> chm = new ConcurrentHashMap<Integer, Set>();
        List<Integer> list = new ArrayList();
        for (int i = 0;i < 10000 ;i++){
            list.add(i);
        }
        list.parallelStream().forEach(i -> {
            int finalI = i;
            Set set =  Collections.synchronizedSet(new HashSet());
//            HashSet set = new HashSet();
            set.add("asd"+ finalI);
            synchronized (HelloController.class) {
                if (chm.get(123) == null) {
                    chm.put(123, set);
                } else {
                    chm.get(123).addAll(set);
                }
            }
        });
//        Thread.sleep(1000);
        System.out.println(chm.get(123).size());
        for (Map.Entry<Integer, Set> integerSetEntry : chm.entrySet()) {
            System.out.println(integerSetEntry.getKey() + ":" + integerSetEntry.getValue());
        }
        System.out.println(chm.get(123).size());
    }*/

//    public static void main(String[] args) {
//        List<Review> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Review review = new Review();
//            review.setReviewId(1L);
//            list.add(review);
//        }
//        Review review = new Review();
//        review.setReviewId(2L);
//        list.add(review);
//        Map<Long, Review> existedDeliveryMap = list.stream()
//                .collect(Collectors.toMap(Review::getReviewId, e -> e));
//        for (Map.Entry<Long, Review> longReviewEntry : existedDeliveryMap.entrySet()) {
//            System.out.println(longReviewEntry.getKey() + "__" + longReviewEntry.getValue());
//        }
//    }

//    public static void main(String[] args) {
//        List<Review> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Review review = new Review();
//            review.setReviewId(1L);
//            list.add(review);
//        }
//        Review review = new Review();
//        review.setReviewId(2L);
//        list.add(review);
//        for (Review review1 : list) {
//            System.out.println(review1.getReviewId());
//        }
//        System.out.println("------------------");
//        list = list.stream().collect(
//                Collectors.collectingAndThen(
//                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o->o.getReviewId()))), ArrayList::new));
//        for (Review review1 : list) {
//            System.out.println(review1.getReviewId());
//        }
//
//    }

//    public static void main(String[] args) {
//        Double charge = 100D;
//        String type = RechargeTypeEnum.CASH.getValue();
//        //新手
//        if (type.equals(RechargeTypeEnum.CASH.getValue())){
//            System.out.println(charge*1);
//        } else if (type.equals(RechargeTypeEnum.BANK.getValue())){
//            System.out.println(charge*0.8);
//        } else if (type.equals(RechargeTypeEnum.MOBILE.getValue())){
//            System.out.println(charge*0.9);
//        } else if (type.equals(RechargeTypeEnum.OTHER.getValue())){
//            System.out.println(charge+charge*0.1);
//        }
//
//        //使用策略模式
//        Context context = new Context();
//        double getCharge = context.callCharge(charge, RechargeTypeEnum.BANK.getCode());
//        System.out.println(getCharge);
//    }

    /*public static void main(String[] args) {
        long test = 1;
        int test2 = 1;
        if (test == test2){
            System.out.println("1");
        }else {
            System.out.println("2");
        }
    }*/

    /*@Test
    public void testOrderNotEqual() {
        File file=new File("F:\\newdata.txt");
        BufferedReader reader=null;
        String temp=null;
        File file1=new File("F:\\data.txt");
        BufferedReader reader1=null;
        String temp1=null;
        int line=1;
        try{
            reader=new BufferedReader(new FileReader(file));
            Map<String,Integer> map = new HashMap<>();
            while((temp=reader.readLine())!=null){
                temp = temp.trim();
                if (!map.containsKey(temp)) {
                    map.put(temp,1);
                }
            }

            reader1=new BufferedReader(new FileReader(file1));
            Map<String,Integer> map1 = new HashMap<>();
            while((temp1=reader1.readLine())!=null){
                temp1 = temp1.trim();
                if (!map1.containsKey(temp1)) {
                    map1.put(temp1, 1);
                }
            }
            //
            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                if (!map1.containsKey(entry.getKey())) {
                    System.out.println("不同的作业单：" + entry.getKey());
                }
            }

            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                if (!map.containsKey(entry.getKey())) {
                    System.out.println("不同的作业单：" + entry.getKey());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(reader!=null){
                try{
                    reader.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }*/
}
