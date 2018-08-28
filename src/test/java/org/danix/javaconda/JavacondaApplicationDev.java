package org.danix.javaconda;

import org.danix.javaconda.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
public class JavacondaApplicationDev {

    @Configuration
    @Import(AppConfig.class)
    static class DevConfig {

    }

    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        SpringApplication.run(DevConfig.class, args);
    }
}
