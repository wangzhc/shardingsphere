package com.example.manager;

import com.example.BaseTest;
import com.example.common.util.IdGenerateUtil;
import com.example.entity.pojo.Alone;
import com.example.shardingsphere.precise.OrderShardingAlgorithm;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author wangzhongcai
 * @date 2019/3/21
 */
public class AloneManagerTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(OrderShardingAlgorithm.class);

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

    @Test
    public void queryList() {
//        Long start = 0L;
//        Long pageSize = 2L;
//        List<Alone> list = null;
//        do {
//            list = aloneManager.queryList(start, pageSize);
//            System.out.println("listSize=" + list.size());
//            if (!CollectionUtils.isEmpty(list)) {
//                for (Alone alone : list) {
//                    System.out.println("userId=" + alone.getUserId() + ", score:" + alone.getScore());
//                }
//            }
//            start += pageSize;
//        } while (!CollectionUtils.isEmpty(list));
        Long start = 2L;
        Long pageSize = 2L;
        List<Alone> list = aloneManager.queryList(start, pageSize);
        System.out.println("listSize =" + list.size());
    }
}