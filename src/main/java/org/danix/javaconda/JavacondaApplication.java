package org.danix.javaconda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JavacondaApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavacondaApplication.class, args);
    }
}
