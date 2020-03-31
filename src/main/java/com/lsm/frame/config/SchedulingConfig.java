package com.lsm.frame.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 * @author lsm
 * @date 2020.3.31
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {


//    @Scheduled(cron = "0/5 * * * * ?") //每5秒执行一次
//    public void scheduler() {
//        System.out.println("测试定时任务");
//    }
}
