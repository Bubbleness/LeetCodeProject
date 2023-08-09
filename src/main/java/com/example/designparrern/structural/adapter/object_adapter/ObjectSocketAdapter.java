package com.example.designparrern.structural.adapter.object_adapter;

import com.example.designparrern.structural.adapter.Connection;
import com.example.designparrern.structural.adapter.HdmiSocket;

/**
 * @author shuiyu
 * @date 2023/07/14
 * @description 适配器模式 - 对象适配器模式 - 适配器Adapter类
 */
public class ObjectSocketAdapter implements Connection {

    /**
     * Adaptee对象（被适配者对象）
     */
    private HdmiSocket hdmiSocket;

    public ObjectSocketAdapter(HdmiSocket hdmiSocket) {
        this.hdmiSocket = hdmiSocket;
    }

    @Override
    public void connectToMonitor() {
        System.out.println("正在进行「Type-C」接口到「HDMI」接口的转换 .......");
        hdmiSocket.connectWithHdmiSocket();
        System.out.println("接口转换完成！Mac book pro 电脑已经成功连接上显示器～");
    }
}
