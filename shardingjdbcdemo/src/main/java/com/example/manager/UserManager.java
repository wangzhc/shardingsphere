package com.example.manager;

import com.example.common.util.IdGenerateUtil;
import com.example.entity.pojo.User;
import com.example.orm.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserManager {

    @Resource
    private UserMapper userMapper;

    public int insert(User pojo){
        long id = IdGenerateUtil.getSnowId();
        pojo.setUserId(id);
        return userMapper.insert(pojo);
    }

    public int insertSelective(User pojo){
        long id = IdGenerateUtil.getSnowId();
        pojo.setUserId(id);
        return userMapper.insertSelective(pojo);
    }

    public int insertList(List<User> pojos){
        for(User pojo : pojos) {
            long id = IdGenerateUtil.getSnowId();
            pojo.setUserId(id);
        }
        return userMapper.insertList(pojos);
    }

    public int update(User pojo){
        return userMapper.update(pojo);
    }
}
