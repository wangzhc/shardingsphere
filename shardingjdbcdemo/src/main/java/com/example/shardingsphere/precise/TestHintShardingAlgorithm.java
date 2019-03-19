package com.example.shardingsphere.precise;

import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * 通过Hint而非SQL解析的方式分片的策略
 */
public class TestHintShardingAlgorithm implements HintShardingAlgorithm {

    private static Logger logger = LoggerFactory.getLogger(OrderShardingAlgorithm.class);

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ShardingValue shardingValue) {
        logger.info("Hint分片 availableTargetNames:{}, shardingValue:{}", availableTargetNames, shardingValue);
        return availableTargetNames;
    }

}
