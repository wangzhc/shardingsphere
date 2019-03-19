package com.example.manager;

import com.example.BaseTest;
import com.example.entity.pojo.Order;
import com.example.entity.pojo.OrderItem;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author wangzhongcai
 * @date 2019/3/14
 */
public class OrderManagerTest extends BaseTest {

    @Autowired
    private OrderManager orderManager;
    @Autowired
    private OrderItemManager orderItemManager;

    @Test
    public void insert() {
        Order order = new Order();
        order.setUserId(313033578071982081L);
        order.setDescription("wzc order");
        order.setCreateTime(new Date());
        int flag = orderManager.insert(order);
        System.out.println("flag=" + flag);
    }

    @Test
    public void addOrderAndOrderItem() {
        Order order = new Order();
        order.setUserId(313033580894748672L);//313033578071982081L
        order.setDescription("wzc order");
        order.setCreateTime(new Date());
        orderManager.insert(order);

        List<OrderItem> itemList = Lists.newArrayList();

        for (int i = 0; i < 100; i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setUserId(313033580894748672L);//313033578071982081L
            orderItem.setDescription("wzc order item " + i);
            itemList.add(orderItem);
        }
        orderItemManager.insertList(itemList);
    }

    @Test
    public void queryList() {
        List<Order> orderList = orderManager.queryList();
        System.out.println("flagSize =" + orderList.size());
    }

}