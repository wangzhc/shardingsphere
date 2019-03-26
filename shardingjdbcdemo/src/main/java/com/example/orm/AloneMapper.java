package com.example.orm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.example.entity.pojo.Alone;

@Mapper
public interface AloneMapper {
    int insert(@Param("pojo") Alone pojo);

    int insertSelective(@Param("pojo") Alone pojo);

    int insertList(@Param("pojos") List<Alone> pojo);

    int update(@Param("pojo") Alone pojo);

    /**
     * 默认数据源分页存在BUG
     * @param start
     * @param pageSize
     * @return
     */
    List<Alone> queryList(@Param("start") Long start, @Param("pageSize") Long pageSize);
}
