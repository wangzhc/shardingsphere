package com.example.manager;

import com.example.BaseTest;
import com.example.common.util.IdGenerateUtil;
import com.example.entity.pojo.Trade;
import com.example.shardingsphere.precise.TradeShardingAlgorithm;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author wangzhongcai
 * @date 2019/3/18
 */
public class TradeManagerTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(TradeManagerTest.class);

    @Autowired
    private TradeManager tradeManager;

    @Test
    public void insert() {
        Trade pojo = new Trade.Builder()
                .userId(IdGenerateUtil.getSnowId())
                .score(101)
                .createTime(new Date())
                .build();
        int flag = tradeManager.insert(pojo);
        System.out.println("falg=" + flag);
    }

    @Test
    public void insertCompany() {
        Random random = new Random();
        Trade pojo = new Trade.Builder()
                .userId(TradeShardingAlgorithm.company_0)
                .score(random.nextInt(100))
                .createTime(new Date())
                .build();
        int flag = tradeManager.insert(pojo);
        pojo = new Trade.Builder()
                .userId(TradeShardingAlgorithm.company_1)
                .score(random.nextInt(100))
                .createTime(new Date())
                .build();
        flag += tradeManager.insert(pojo);
        System.out.println("falg=" + flag);
    }

    @Test
    public void insertList() {
        List<Trade> pojos = Lists.newArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Trade pojo = new Trade.Builder()
                    //采用默认分布式主键配置作为分片主键存在BUG
                    //TradeShardingAlgorithm.company_0
                    //.userId(IdGenerateUtil.getSnowId())
                    .userId(315127082818469919L)
                    .score(random.nextInt(100))
                    .createTime(new Date())
                    .build();
            pojos.add(pojo);
        }
        int flag = tradeManager.insertList(pojos);
    }

    @Test
    public void queryList(){
        Long start = 0L;
        Long pageSize = 10L;
        List<Trade> list = null;
        do {
            list = tradeManager.queryList(start);
            System.out.println("listSize=" + list.size());
            if (!CollectionUtils.isEmpty(list)) {
                for (Trade trade : list) {
                    System.out.println("userId=" + trade.getUserId() + ", score:" + trade.getScore());
                }
            }
            start += pageSize;
        } while (!CollectionUtils.isEmpty(list));
    }
}