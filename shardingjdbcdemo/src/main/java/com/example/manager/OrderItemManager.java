package com.example.manager;

import com.example.common.util.IdGenerateUtil;
import com.example.orm.OrderItemMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.example.entity.pojo.OrderItem;

@Service
public class OrderItemManager {

    @Resource
    private OrderItemMapper orderItemMapper;

    public int insert(OrderItem pojo){
        long id = IdGenerateUtil.getSnowId();
        pojo.setOrderItemId(id);
        return orderItemMapper.insert(pojo);
    }

    public int insertSelective(OrderItem pojo){
        long id = IdGenerateUtil.getSnowId();
        pojo.setOrderItemId(id);
        return orderItemMapper.insertSelective(pojo);
    }

    public int insertList(List<OrderItem> pojos){
        for(OrderItem pojo : pojos) {
            long id = IdGenerateUtil.getSnowId();
            pojo.setOrderItemId(id);
        }
        return orderItemMapper.insertList(pojos);
    }

    public int update(OrderItem pojo){
        return orderItemMapper.update(pojo);
    }
}
