package com.example.common.util;

import org.junit.Test;
/**
 * @author wangzhongcai
 * @date 2019/3/14
 */
public class IdGenerateUtilTest {

    @Test
    public void getSnowId() {
    for (int i = 0; i < 1000; i++){
            long id = IdGenerateUtil.getSnowId();
            System.out.println(id);
        }
    }
}