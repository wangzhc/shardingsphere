package com.example.entity.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
    private Long orderItemId;
    private Long orderId;
    private Long userId;
    private String description;
}
