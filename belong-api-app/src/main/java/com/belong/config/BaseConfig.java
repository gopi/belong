package com.belong.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Base configuration for the System, handles configuration of SpringBoot  .
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.belong.*"})
@EntityScan(basePackages = {"com.belong.model.data"})
public class BaseConfig {
    
}