package com.example.designparrern.behavioral.observer;

/**
 * @author shuiyu
 */
public class ObserverTest {

    public static void main(String[] args) {
        // 走路的行人
        People pedestrian  = new Pedestrian();
        // 骑摩托车的人
        People motorcyclist = new Motorcyclist();
        // 开车的人
        People driver = new Driver();

        // 交警
        TrafficSign trafficPolice = new TrafficPolice();
        // 红绿灯
        TrafficSign trafficLight = new TrafficLight();

        // 注册观察者人员
        trafficPolice.register(pedestrian);
        trafficPolice.register(motorcyclist);
        trafficPolice.register(driver);
        // 交警发送通知消息
        trafficPolice.notify("我是交警，现在大家可以通行了...");

        System.out.println("==============================================");
        // 注册观察者人员
        trafficLight.register(pedestrian);
        trafficLight.register(motorcyclist);
        trafficLight.register(driver);
        // 红绿灯发送通知消息
        trafficLight.notify("红绿灯变绿啦，现在大家可以通行了...");
    }
}
