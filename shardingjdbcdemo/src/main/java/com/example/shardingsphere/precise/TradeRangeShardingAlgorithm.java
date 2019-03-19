package com.example.shardingsphere.precise;

import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 范围分片算法
 */
public class TradeRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    private static Logger logger = LoggerFactory.getLogger(TradeShardingAlgorithm.class);

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        logger.info("范围分片算法 availableTargetNames:{}, shardingValue:{}", availableTargetNames, shardingValue);
        Collection<String> collect = new ArrayList<>();
        for (String name : availableTargetNames) {
            if (name.endsWith("_company")) {
                collect.add(name);
            }
        }
        logger.info("范围分片算法 collect:{}", collect);
        return availableTargetNames;
    }
}
