package com.example.designparrern.adapter.class_adapter;

import com.example.designparrern.adapter.Connection;
import com.example.designparrern.adapter.HdmiSocket;

/**
 * @author shuiyu
 * @date 2023/07/14
 * @description 适配器模式 - 类适配器模式 - 适配器Adapter类
 */
public class ClazzSocketAdapter extends HdmiSocket implements Connection {

    @Override
    public void connectToMonitor() {
        System.out.println("Mac book pro 电脑的「Type-C」接口正在转换为「HDMI」接口......");
        this.connectWithHdmiSocket();
        System.out.println("转换完成～ Mac book pro 电脑已经成功外接显示器～");
    }
}
