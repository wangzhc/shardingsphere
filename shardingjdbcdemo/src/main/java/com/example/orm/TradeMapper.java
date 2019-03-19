package com.example.orm;

import com.example.entity.pojo.Trade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TradeMapper {
    int insert(@Param("pojo") Trade pojo);

    int insertSelective(@Param("pojo") Trade pojo);

    int insertList(@Param("pojos") List<Trade> pojo);

    int update(@Param("pojo") Trade pojo);

    List<Trade> queryList(@Param("minUserId") Long minUserId,
                          @Param("maxUserId") Long maxUserId,
                          @Param("start") Long start);
}
