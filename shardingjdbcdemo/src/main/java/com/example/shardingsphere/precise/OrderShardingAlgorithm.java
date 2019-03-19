package com.example.shardingsphere.precise;

import com.example.common.constants.TimeConstant;
import com.example.common.util.DateUtil;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * 精确分片算法
 */
public class OrderShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private static Logger logger = LoggerFactory.getLogger(OrderShardingAlgorithm.class);

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        logger.info("精确分片 collection:{}, preciseShardingValue:{}", collection, preciseShardingValue);
        Long id = preciseShardingValue.getValue();
        // 获取时间（年月日）
        Long time = id >> 22;
        time += TimeConstant.START_UNIX_TIME;
        String timeString = DateUtil.unixToDateString(time, TimeConstant.DATE_FORMAT_YEAR_MONTH);

        for (String each : collection) {
            if (each.endsWith(timeString)) {
                logger.info("精确分片 each:{}", each);
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
