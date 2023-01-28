package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.SQLException;
@SpringBootTest
class DemoApplicationTests {
    @Autowired
              DataSource dateSource;
    @Test
    void contextLoads() throws SQLException {
        // 查看一下默认数据源   com.zaxxer.hikari.HikariDataSource;
        System.out.println(dateSource.getClass());
        System.out.println(dateSource.getConnection());
    }
}
