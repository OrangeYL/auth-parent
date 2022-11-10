package com.orange.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Li ZhiCheng
 * @create: 2022-10-2022/10/27 16:57
 * @description:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.orange.system.mapper")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class,args);
    }
}
