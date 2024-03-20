//package com.example.test;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @author shuiyu
// * @date 2023/09/26
// */
//public class TestReentrantLock {
//
//    private int successCount;
//    private ReentrantLock lock;
//    private Condition writeCondition;
//    private Condition queryCondition;
//
//    public TestReentrantLock() {
//        lock = new ReentrantLock();
//        writeCondition = lock.newCondition();
//        queryCondition = lock.newCondition();
//    }
//
//    public void writeData() {
//        lock.lock();
//        try {
//
//            System.out.println("写线程被阻塞");
//            if (successCount != 10) {
//                writeCondition.await(); // 阻塞写线程
//                queryCondition.signal();
//            }
//
//            // 写入数据的逻辑
//            System.out.println("写入数据，成功记录数：" + successCount);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void queryData() {
//        lock.lock();
//        try {
//
//            while (true) {
//                successCount++;
//                Thread.sleep(1000);
//                if (successCount == 10) {
//
//                    writeCondition.signal();
//                    queryCondition.await();
//                    break;
//                }
//            }
//            // 查询数据的逻辑
//            int records = 50; // 模拟查询到的记录数
//            successCount += records;
//            System.out.println("查询到数据，新增成功记录数：" + records);
//            Thread.sleep(5000); // 休眠5秒
//            writeCondition.signal(); // 唤醒写线程
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//}
