package com.example.designparrern.adapter;

import com.example.designparrern.adapter.class_adapter.ClazzSocketAdapter;
import com.example.designparrern.adapter.object_adapter.ObjectSocketAdapter;

/**
 * @author shuiyu
 * @date 2023/07/14
 * @description 适配器模式 - Client类 参考：<a href="https://juejin.cn/post/7118956732721987614">一次性搞懂设计模式--适配器模式</>
 */
public class MacBookProComputer {

    /**
     * 一台mac book pro电脑只有type-c接口，现在想要外接一台显示器，然而显示器只有HDMI接口
     * 因此需要对电脑的接口进行适配，这样才能外接显示器
     * 总结：
     *    1. 适配器模式的作用就是连接「现有程序」和「所需程序」，客户给定一个定义类相关标准的接口，开发者需要在用户给定的接口上利用
     *       程序中已知的类来完成相关的功能
     *    2. 适配者模式有4个角色：Client（请求者，也就是客户）、Target（目标接口，也就是客户给定的接口）、Adapter（适配器）和 Adaptee（被适配对象）
     *       Client会调用自己定义的接口Target的方法，开发者需要利用已经存在的Adaptee类来提供服务，所有需要写一个适配器Adapter来适配程序，使得
     *       Client在调用Target中的方法时，能够调用到Adaptee类中的方法
     *    3. 个人理解：这个模式的一个使用前提是Target类明确给出
     */
    public static void main(String[] args) {

        useClazzAdapterMethod();
        System.out.println("==========================");
        useObjectAdapterMethod();
    }

    /**
     * 使用类适配器模式
     */
    public static void useClazzAdapterMethod() {
        Connection connection = new ClazzSocketAdapter();
        connection.connectToMonitor();
    }

    public static void useObjectAdapterMethod() {
        HdmiSocket hdmiSocket = new HdmiSocket();
        Connection connection = new ObjectSocketAdapter(hdmiSocket);
        connection.connectToMonitor();
    }

}
