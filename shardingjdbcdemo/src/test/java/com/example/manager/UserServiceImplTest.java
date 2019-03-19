package com.example.manager;

import com.example.BaseTest;
import com.example.entity.pojo.User;
import com.example.manager.UserManager;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wangzhongcai
 * @date 2019/3/14
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserManager userManager;

    @Test
    public void insert() {
        User user = new User();
        user.setName("wzc");
        user.setAge(11);
        user.setAddress("深圳市");
        int flag = userManager.insert(user);
        System.out.println("flag=" + flag);
    }

    @Test
    public void insertList() {
        List userList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("wzc");
            user.setAge(10);
            user.setAddress("深圳市");
            userList.add(user);
        }
        int flag = userManager.insertList(userList);
        System.out.println("flag=" + flag);
    }
}