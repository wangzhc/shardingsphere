package com.example.entity.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {
    private Long orderId;
    private Long userId;
    private String description;
    private Date createTime;

    public Order() { }

    private Order(Builder builder) {
        setOrderId(builder.orderId);
        setUserId(builder.userId);
        setDescription(builder.description);
        setCreateTime(builder.createTime);
    }

    public static final class Builder {
        private Long orderId;
        private Long userId;
        private String description;
        private Date createTime;

        public Builder() {
        }

        public Builder orderId(Long val) {
            orderId = val;
            return this;
        }

        public Builder userId(Long val) {
            userId = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder createTime(Date val) {
            createTime = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
