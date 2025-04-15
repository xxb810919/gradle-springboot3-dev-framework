package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(
        scanBasePackages = {"com.test"},
        exclude = {TransactionAutoConfiguration.class}
)
@ImportResource(locations = {
        "classpath:mybatis-applicationContext.xml",
        "classpath:sqs-applicationContext.xml"
})
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
