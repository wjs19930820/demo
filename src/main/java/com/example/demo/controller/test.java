package com.example.demo.controller;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zsp on 2019/5/10.
 */
public class test {

    /*public static void main(String[] args) throws Throwable {
        OrderGoodsDemo demo = new OrderGoodsDemo();
        long start = System.currentTimeMillis();
        demo.search2();
        System.out.println("- cost: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        demo.search1();
        System.out.println("- cost: " + (System.currentTimeMillis() - start));
    }*/

    private final static int GOODS_SIZE = 200;
    private final static int LOCATION_SIZE = 20;
    private final static int PAGE_FETCH_SIZE = 1000;

    private static Long[] goodsArray;
    private static Long[] locationArray;

    static {
        goodsArray = new Long[GOODS_SIZE];
        for(int i = 0; i < GOODS_SIZE; i++) {
            goodsArray[i] = (long)i;
        }
        locationArray = new Long[LOCATION_SIZE];
        for(int i = 0; i < LOCATION_SIZE; i++) {
            locationArray[i] = (long)i;
        }
    }

    private final Random random = new Random();

    //同步
    public void search1() throws ExecutionException, InterruptedException {
        Map<Long, GoodsReport> goodsReportMap = new HashMap<>();
        Set<Long> goodsIdSet = new HashSet<>();
        List<OrderGoodsReport> orderGoodsReportList;
        Long goodsId;
        //分页获取订单商品明细
        for(int page = 0; ; page++) {
            orderGoodsReportList = fetchOrderGoodsReport(page);
            if(CollectionUtils.isEmpty(orderGoodsReportList)) {
                break;
            }
            for(OrderGoodsReport orderGoodsReport : orderGoodsReportList) {
                GoodsReport goodsReport = goodsReportMap.get(goodsId = orderGoodsReport.getGoodsId());
                if(goodsReport == null) {
                    goodsReport = new GoodsReport();
                    goodsReport.setGoodsId(goodsId);
                    goodsReportMap.put(goodsId, goodsReport);
                    goodsIdSet.add(goodsId);
                    if(goodsIdSet.size() == 20) {
                        //异步发起商品库位的查询
                        fetchLocation(goodsReportMap, goodsIdSet);
                        goodsIdSet.clear();
                    }
                }
                goodsReport.addCount(orderGoodsReport.getCount());
            }
        }
        if(goodsIdSet.size() > 0) {
            //剩余的商品，异步发起商品库位的查询
            fetchLocation(goodsReportMap, goodsIdSet);
            goodsIdSet.clear();
        }

//        for(GoodsReport goodsReport : goodsReportMap.values()) {
//            System.out.println("- " + goodsReport);
//        }
    }

    //异步
    public void search2() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        Map<Long, GoodsReport> goodsReportMap = new HashMap<>();
        Set<Long> goodsIdSet = new HashSet<>();
        List<OrderGoodsReport> orderGoodsReportList;
        Long goodsId;
        List<Future<Boolean>> locationTaskList = new ArrayList<>();
        //分页获取订单商品明细
        for(int page = 0; ; page++) {
            orderGoodsReportList = fetchOrderGoodsReport(page);
            if(CollectionUtils.isEmpty(orderGoodsReportList)) {
                break;
            }
            for(OrderGoodsReport orderGoodsReport : orderGoodsReportList) {
                GoodsReport goodsReport = goodsReportMap.get(goodsId = orderGoodsReport.getGoodsId());
                if(goodsReport == null) {
                    goodsReport = new GoodsReport();
                    goodsReport.setGoodsId(goodsId);
                    goodsReportMap.put(goodsId, goodsReport);
                    goodsIdSet.add(goodsId);
                    if(goodsIdSet.size() == 10) {
                        //异步发起商品库位的查询
                        locationTaskList.add(fetchLocationTask(threadPool, goodsReportMap, new HashSet(goodsIdSet)));
                        goodsIdSet.clear();
                    }
                }
                goodsReport.addCount(orderGoodsReport.getCount());
            }
        }
        if(goodsIdSet.size() > 0) {
            //剩余的商品，异步发起商品库位的查询
            locationTaskList.add(fetchLocationTask(threadPool, goodsReportMap, new HashSet(goodsIdSet)));
            goodsIdSet.clear();
        }
        for(Future<Boolean> task : locationTaskList) {
            //等待异步任务完成
            task.get();
        }

        threadPool.shutdownNow();

//        for(GoodsReport goodsReport : goodsReportMap.values()) {
//            System.out.println("- " + goodsReport);
//        }
    }

    private List<OrderGoodsReport> fetchOrderGoodsReport(int page) throws InterruptedException {
        int offset = page * PAGE_FETCH_SIZE;
        int rows = PAGE_FETCH_SIZE;
        System.out.println("fetchOrderGoodsReport: page= " + page + ", offset=" + offset + ", rows=" + rows);
        Thread.sleep(20);
        if(page < 5) {
            List<OrderGoodsReport> list = new ArrayList<>();
            for (int i = offset, len = offset + rows; i < len; i++) {
                OrderGoodsReport report = new OrderGoodsReport();
                report.setGoodsId(goodsArray[random.nextInt(GOODS_SIZE)]);
                report.setCount(1);
                list.add(report);
            }
            return list;
        }
        return null;
    }

    private Future<Boolean> fetchLocationTask(ExecutorService threadPool,
                                              Map<Long, GoodsReport> goodsReportMap, Set<Long> goodsIdSet) {
        return threadPool.submit(() -> fetchLocation(goodsReportMap, goodsIdSet));
    }

    private boolean fetchLocation(Map<Long, GoodsReport> goodsReportMap, Set<Long> goodsIdSet) throws InterruptedException {
        System.out.println("fetchLocation");
        Thread.sleep(50);
        for(Long goodsId : goodsIdSet) {
            GoodsReport goodsReport = goodsReportMap.get(goodsId);
            goodsReport.setLocationList(Arrays.asList(locationArray[random.nextInt(LOCATION_SIZE)]));
        }
        return true;
    }

    static class GoodsReport {
        private Long goodsId;
        private int count;
        private List<Long> locationList;

        public void addCount(int delta) {
            count += delta;
        }

        @Override
        public String toString() {
            return "GoodsReport{" +
                    "goodsId=" + goodsId +
                    ", count=" + count +
                    ", locationList=" + locationList +
                    '}';
        }

        public Long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Long goodsId) {
            this.goodsId = goodsId;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Long> getLocationList() {
            return locationList;
        }

        public void setLocationList(List<Long> locationList) {
            this.locationList = locationList;
        }
    }

    static class OrderGoodsReport {
        private Long goodsId;
        private int count;

        public Long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Long goodsId) {
            this.goodsId = goodsId;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    static class Location {

    }

}

