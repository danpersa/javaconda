package org.danix.javaconda;

import org.danix.javaconda.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.AbstractEnvironment;

public class JavacondaApplication {

    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
        SpringApplication.run(AppConfig.class, args);
    }
}
