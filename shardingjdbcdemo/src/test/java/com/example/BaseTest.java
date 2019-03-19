package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShardingjdbcdemoApplication.class)
@ActiveProfiles(profiles = "dev")
public class BaseTest {

    static {
        System.setProperty("env", "dev");
    }

}
