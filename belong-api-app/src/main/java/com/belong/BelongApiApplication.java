package com.belong;

import com.belong.config.BaseConfig;
import com.belong.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BaseConfig.class, SwaggerConfig.class})
public class BelongApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(BelongApiApplication.class, args);

    }
}