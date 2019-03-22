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

    /*
    默认数据源分页存在BUG：
    io.shardingsphere.core.routing.router.sharding.ParsingSQLRouter.route
    @Override
    public SQLRouteResult route(final String logicSQL, final List<Object> parameters, final SQLStatement sqlStatement) {
        Optional<GeneratedKey> generatedKey = sqlStatement instanceof InsertStatement ? getGenerateKey(shardingRule, (InsertStatement) sqlStatement, parameters) : Optional.<GeneratedKey>absent();
        SQLRouteResult result = new SQLRouteResult(sqlStatement, generatedKey.orNull());
        //从所有参数中筛选出分片字段及参数，如果分片字段不存在，将会返回一个默认配置“总是不分片配置”
        ShardingConditions shardingConditions = OptimizeEngineFactory.newInstance(shardingRule, sqlStatement, parameters, generatedKey.orNull()).optimize();
        if (generatedKey.isPresent()) {
            //设置主键key
            setGeneratedKeys(result, generatedKey.get());
        }
        if (sqlStatement instanceof SelectStatement && !sqlStatement.getTables().isEmpty() && !((SelectStatement) sqlStatement).getSubQueryConditions().isEmpty()) {
            //检查是否包含不支持的子查询
            mergeShardingValueForSubQuery(sqlStatement.getConditions(), shardingConditions);
        }
        //计算路由结果
        RoutingResult routingResult = RoutingEngineFactory.newInstance(shardingRule, shardingMetaData.getDataSource(), sqlStatement, shardingConditions).route();
        SQLRewriteEngine rewriteEngine = new SQLRewriteEngine(shardingRule, logicSQL, databaseType, sqlStatement, shardingConditions, parameters);
        if (sqlStatement instanceof SelectStatement && null != ((SelectStatement) sqlStatement).getLimit()) {
            processLimit(parameters, (SelectStatement) sqlStatement);
            //TODO：3.1.0分页BUG 处理limit语句，关于分页查询，单表路由和多表路由在此处有特殊处理
            //processLimit(parameters, (SelectStatement) sqlStatement, routingResult.isSingleRouting());
        }
        //将逻辑SQL重写为实际的SQL(根据sql解析器生成的解析树重写每一段sql)
        SQLBuilder sqlBuilder = rewriteEngine.rewrite(routingResult.isSingleRouting());
        for (TableUnit each : routingResult.getTableUnits().getTableUnits()) {
            result.getRouteUnits().add(new RouteUnit(each.getDataSourceName(), rewriteEngine.generateSQL(each, sqlBuilder, shardingMetaData.getDataSource())));
        }
        //打印sql日志
        if (showSQL) {
            SQLLogger.logSQL(logicSQL, sqlStatement, result.getRouteUnits());
        }
        return result;
    }

    private void processLimit(final List<Object> parameters, final SelectStatement selectStatement, final boolean isSingleRouting) {
        if (isSingleRouting) {
            //单表路由，limit语句不处理
            selectStatement.setLimit(null);
            return;
        }

        boolean isNeedFetchAll = (!selectStatement.getGroupByItems().isEmpty() || !selectStatement.getAggregationSelectItems().isEmpty()) && !selectStatement.isSameGroupByAndOrderByItems();
        selectStatement.getLimit().processParameters(parameters, isNeedFetchAll, databaseType);
    }
    */
}
