package com.example.designparrern.builder.simplified;

/**
 * @author shuiyu
 * @date 2023/08/08
 * @description 简化版建造者模式
 */
public class MobilePhoneNew {

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

    public MobilePhoneNew(Builder builder) {
        this.brand = builder.brand;
        this.price = builder.price;
        this.type = builder.type;
        this.processor = builder.processor;
        this.colour = builder.colour;
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

    public static class Builder {
        private String brand;
        private Double price;
        private String type;
        private String processor;
        private String colour;

        public Builder(String brand, Double price) {
            this.brand = brand;
            this.price = price;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public MobilePhoneNew build() {
            return new MobilePhoneNew(this);
        }
    }
}
