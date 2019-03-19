package com.example.manager;

import com.example.common.util.IdGenerateUtil;
import com.example.entity.pojo.Order;
import com.example.orm.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderManager {

    @Resource
    private OrderMapper orderMapper;

    public int insert(Order pojo){
        long id = IdGenerateUtil.getSnowId();
        pojo.setOrderId(id);
        return orderMapper.insert(pojo);
    }

    public int insertSelective(Order pojo){
        long id = IdGenerateUtil.getSnowId();
        pojo.setOrderId(id);
        return orderMapper.insertSelective(pojo);
    }

    public int insertList(List<Order> pojos){
        for(Order pojo : pojos) {
            long id = IdGenerateUtil.getSnowId();
            pojo.setOrderId(id);
        }
        return orderMapper.insertList(pojos);
    }

    public int update(Order pojo){
        return orderMapper.update(pojo);
    }

    public List<Order> queryList(){
        return orderMapper.queryList();
    }
}
