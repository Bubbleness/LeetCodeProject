package com.example.designparrern.behavioral.chain.improve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

import com.example.designparrern.behavioral.chain.AttackRequest;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.util.StringUtils;

/**
 * @author shuiyu
 * @date 2023/08/27
 */
public class ImprovedChainMainTest {

    public static void main(String[] args) throws InterruptedException {

        //AttackRequest attackRequest1 = new AttackRequest("Missile", "日本");
        //AttackRequest attackRequest2 = new AttackRequest("Hydrogen Bomb", "日本");
        //AttackRequest attackRequest3 = new AttackRequest("Nuclear Bomb", "日本");
        //AttackRequest attackRequest4 = new AttackRequest("Bomb", "日本");
        //
        //ApproverChain chain = new ApproverChain();
        //ImprovedRegimentalCommander regimentalCommander = new ImprovedRegimentalCommander();
        //ImprovedDivisionCommander divisionCommander = new ImprovedDivisionCommander();
        //ImprovedCommander commander = new ImprovedCommander();
        //
        //chain.addHandler(regimentalCommander);
        //chain.addHandler(divisionCommander);
        //chain.addHandler(commander);
        //
        //chain.handle(attackRequest1);
        //chain.handle(attackRequest2);
        //chain.handle(attackRequest3);
        //// 这种写法要求请求必须被一个处理器给处理
        //chain.handle(attackRequest4);
        //
        //String str1 = "/000004-0/000004-5/002162-0/010625-0";
        //String str2 = "/000004-0/000004-5/002162-0/010625-4";
        //
        //String str3 = "/000004-0/080124-0/080124-13/002162-10";
        //String str4 = "/000004-0/000011-0/002162-13/002162-15";
        //String str5 = "/000004-0/000004-5/002162-0";
        //String str6 = "/000004-0/000011-0/002162-13";
        //
        //List<List<String>> jobs = new ArrayList<>();
        //jobs.add(Arrays.asList(str1.substring(1).split("/")));
        //jobs.add(Arrays.asList(str2.substring(1).split("/")));
        //System.out.println(JSON.toJSONString(jobs));


        //ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        //executorService.scheduleAtFixedRate(() -> {
        //    // 要执行的任务逻辑
        //    System.out.println("执行任务");
        //}, 0, 5, TimeUnit.SECONDS);

        //List<User> userList = new ArrayList<>();
        //Map<String, String> userMap = userList.stream()
        //    .collect(Collectors.toMap(User::getName, User::getPassword, (o1,o2)->o1));
        //System.out.println(JSON.toJSONString(userMap));

        //Date now = new Date();
        //Thread.sleep(30000);
        //Date newTime = new Date();
        //
        //long diff = Math.abs(now.getTime() - newTime.getTime());
        //System.out.println(diff);
        //double minute = (double)diff / (1000 * 60);
        //System.out.println(minute);

        String str = "okr://progress/6567f7af8c4ad8192d8807b6";
        System.out.println(extractProgressId(str));

    }

    private static String extractProgressId(String uploadDocUrl) {

        if (StringUtils.isEmpty(uploadDocUrl)) {
            return null;
        }
        // okr://progress/6567f7af8c4ad8192d8807b6
        int index = uploadDocUrl.lastIndexOf("/");
        if (index != -1) {
            return uploadDocUrl.substring(index + 1);
        }
        return null;
    }

    private static void scheduler(ReentrantLock lock, Condition condition) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        lock.lock();
        try {
            executorService.scheduleAtFixedRate(() -> {
                // 要执行的任务逻辑
                System.out.println("执行任务");
            }, 0, 5, TimeUnit.SECONDS);
        } catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }
}
