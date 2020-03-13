package com.lanboo.sharding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lanboo
 * @date 2020/3/13 17:56
 */
@SpringBootApplication
@Slf4j
public class ShardingWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingWebApplication.class, args);
        log.info("---------------------------------ShardingWebApplication start success-------------------------------");
    }
}
