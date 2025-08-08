package com.sky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
@Slf4j
public class SkyApplication {
    public static void main(String[] args) {
        // 启动前检查所有相关的系统属性
        System.out.println("=== 启动前系统属性检查 ===");
        Properties props = System.getProperties();
        for (String name : props.stringPropertyNames()) {
            if (name.toLowerCase().contains("druid") ||
                name.toLowerCase().contains("datasource") ||
                name.toLowerCase().contains("mysql")) {
                System.out.println(name + " = " + props.getProperty(name));
            }
        }
        SpringApplication.run(SkyApplication.class, args);
        log.info("server started");
    }
}
