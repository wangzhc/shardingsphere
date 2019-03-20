package com.example.manager;

import com.example.common.util.IdGenerateUtil;
import com.example.entity.pojo.Trade;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.example.orm.TradeMapper;

@Service
public class TradeManager{

    @Resource
    private TradeMapper tradeMapper;

    public int insert(Trade pojo){
        //long id = IdGenerateUtil.getSnowId();
        //pojo.setId(id);
        return tradeMapper.insert(pojo);
    }

    public int insertSelective(Trade pojo){
        long id = IdGenerateUtil.getSnowId();
        pojo.setId(id);
        return tradeMapper.insertSelective(pojo);
    }

    public int insertList(List<Trade> pojos){
        for(Trade pojo : pojos){
            long id = IdGenerateUtil.getSnowId();
            pojo.setId(id);
        }
        return tradeMapper.insertList(pojos);
    }

    public int update(Trade pojo){
        return tradeMapper.update(pojo);
    }

    public List<Trade> queryList(Long start){
        return tradeMapper.queryList(start);
    }
}
