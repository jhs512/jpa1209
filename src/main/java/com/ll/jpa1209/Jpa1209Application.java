package com.ll.jpa1209;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 10강, 파트 1, 2부
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //@CreatedDate, @LastModifiedDate를 사용하기 위해 필요
public class Jpa1209Application {

    public static void main(String[] args) {
        SpringApplication.run(Jpa1209Application.class, args);
    }

}
