package com.example.designparrern.builder.traditional;

/**
 * @author shuiyu
 * @date 2023/08/08
 * @description 构建者模式 - Product角色 - 最终要生成（构建）的对象
 */
public class MobilePhone {

    /**
     * 手机品牌（必填）
     */
    private String brand;

    /**
     * 手机价格（必填）
     */
    private Double price;

    /**
     * 手机型号（选填）
     */
    private String type;

    /**
     * 手机处理器（选填）
     */
    private String processor;

    /**
     * 手机颜色（选填）
     */
    private String colour;

    public MobilePhone(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "MobilePhoneNew{" +
            "brand='" + brand + '\'' +
            ", price=" + price +
            ", type='" + type + '\'' +
            ", processor='" + processor + '\'' +
            ", colour='" + colour + '\'' +
            '}';
    }
}
