package com.example.homework47_rest_main_feignclient.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.homework47_rest_main_feignclient.client")
public class AppConfig {
}
