package com.example.shardingsphere.precise;

import com.google.common.collect.Sets;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Set;

/**
 * 精确分片算法
 */
public class TradeShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private static Logger logger = LoggerFactory.getLogger(TradeShardingAlgorithm.class);

    public static Long company_0 = 313033581150601216L;
    public static Long company_1 = 313033578071982081L;
    public static Set<Long> company = Sets.newHashSet(company_0, company_1);

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        long value = preciseShardingValue.getValue();
        //特殊账户入特殊的库: t_trade_company
        if (company.contains(value)) {
            for (String name : collection) {
                if (name.endsWith("_company")) {
                    logger.info("精确分片算法:{}", name);
                    return name;
                }
            }
        }
        //按模路由的库: t_trade_0, t_trade_1, t_trade_2
        int size = collection.size() - 1;
        String text = "_" + String.valueOf(value % size);
        for (String name : collection) {
            if (name.endsWith(text)) {
                logger.info("精确分片算法:{}", name);
                return name;
            }
        }
        throw new IllegalArgumentException();
    }
}
