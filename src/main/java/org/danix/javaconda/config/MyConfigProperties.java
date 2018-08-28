package org.danix.javaconda.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Component
@ConfigurationProperties(prefix = "service.url")
@Validated
public class MyConfigProperties {

    @NotBlank
    private String quoters;

    public String getQuoters() {
        return quoters;
    }

    public void setQuoters(String quoters) {
        this.quoters = quoters;
    }
}
