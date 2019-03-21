package com.example.manager;

import com.example.BaseTest;
import com.example.common.util.IdGenerateUtil;
import com.example.entity.pojo.Alone;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author wangzhongcai
 * @date 2019/3/21
 */
public class AloneManagerTest extends BaseTest {

    @Autowired
    private AloneManager aloneManager;

    @Test
    public void insert() {
        Alone pojo = new Alone.Builder()
                .userId(IdGenerateUtil.getSnowId())
                .score(101)
                .createTime(new Date())
                .build();
        int flag = aloneManager.insert(pojo);
        System.out.println("falg=" + flag);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void insertList() {
    }

    @Test
    public void update() {
    }
}