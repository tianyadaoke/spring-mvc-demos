package org.zb.springmvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SpringmvcdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcdemoApplication.class, args);
    }

}
