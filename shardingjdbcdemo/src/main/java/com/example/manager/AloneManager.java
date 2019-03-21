package com.example.manager;

import com.example.common.util.IdGenerateUtil;
import com.example.entity.pojo.Alone;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.example.orm.AloneMapper;

@Service
public class AloneManager{

    @Resource
    private AloneMapper aloneMapper;

    public int insert(Alone pojo){
        //long id = IdGenerateUtil.getSnowId();
        //pojo.setId(id);
        return aloneMapper.insert(pojo);
    }

    public int insertSelective(Alone pojo){
        long id = IdGenerateUtil.getSnowId();
        pojo.setId(id);
        return aloneMapper.insertSelective(pojo);
    }

    public int insertList(List<Alone> pojos){
        for(Alone pojo : pojos){
            long id = IdGenerateUtil.getSnowId();
            pojo.setId(id);
        }
        return aloneMapper.insertList(pojos);
    }

    public int update(Alone pojo){
        return aloneMapper.update(pojo);
    }
}
