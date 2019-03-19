package com.example.orm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.example.entity.pojo.OrderItem;

@Mapper
public interface OrderItemMapper {
    int insert(@Param("pojo") OrderItem pojo);

    int insertSelective(@Param("pojo") OrderItem pojo);

    int insertList(@Param("pojos") List<OrderItem> pojo);

    int update(@Param("pojo") OrderItem pojo);
}
