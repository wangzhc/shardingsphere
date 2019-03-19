package com.example.shardingsphere.precise;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * 复合分片
 */
public class TradeComplexShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    private static Logger logger = LoggerFactory.getLogger(TradeShardingAlgorithm.class);

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {
        logger.info("复合分片 availableTargetNames:{}, shardingValues:{}", availableTargetNames, shardingValues);

        List<Long> userIdList = getListShardingValues(shardingValues, "user_id");
        int userIdListSize = userIdList.size();
        List<Long> idList = getListShardingValues(shardingValues, "id");
        int idListSize = idList.size();
        int valueSize = userIdListSize < idListSize ? userIdListSize : idListSize;

        Collection<String> collect = Lists.newArrayList();
        for (int i = 0; i < valueSize; i++) {
            long value = userIdList.get(i) % 10 + idList.get(i) % 10;
            //按模路由的库: t_trade_0, t_trade_1, t_trade_2
            int size = availableTargetNames.size();
            String text = String.valueOf(value % size);
            for (String name : availableTargetNames) {
                if (name.endsWith(text)) {
                    logger.info("复合分片 name:{}, value:{}, userId:{}, id:{}", name, value, userIdList.get(i), idList.get(i));
                    collect.add(name);
                }
            }
        }
        logger.info("复合分片 collect:{}", collect);
        return collect;
    }

    private List<Long> getListShardingValues(Collection<ShardingValue> shardingValues, String key) {
        if (StringUtils.isEmpty(key)) {
            return Lists.newArrayList();
        }

        List<Long> valus = Lists.newArrayList();
        for (ShardingValue shardingValue : shardingValues) {
            if (shardingValue instanceof ListShardingValue) {
                ListShardingValue listShardingValue = (ListShardingValue) shardingValue;
                if (key.equals(shardingValue.getColumnName())) {
                    valus.addAll(listShardingValue.getValues());
                }
            }
        }
        return valus;
    }
}
