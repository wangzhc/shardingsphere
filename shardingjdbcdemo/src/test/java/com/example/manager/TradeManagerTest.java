package com.example.manager;

import com.example.BaseTest;
import com.example.common.util.IdGenerateUtil;
import com.example.entity.pojo.Trade;
import com.example.shardingsphere.precise.TradeShardingAlgorithm;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author wangzhongcai
 * @date 2019/3/18
 */
public class TradeManagerTest extends BaseTest {

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
                    //TradeShardingAlgorithm.company_0
                    .userId(IdGenerateUtil.getSnowId())
                    .score(random.nextInt(100))
                    .createTime(new Date())
                    .build();
            pojos.add(pojo);
        }
        int flag = tradeManager.insertList(pojos);
    }

    @Test
    public void queryList(){
        Long minUserId = 313033581150601216L;
        Long maxUserId = 314446587885519006L;
        Long start = 0L;
        List<Trade> list = tradeManager.queryList(minUserId, maxUserId, start);
        System.out.println("listSize=" + list.size());
    }
}