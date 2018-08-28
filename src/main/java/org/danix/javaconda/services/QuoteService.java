package org.danix.javaconda.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.danix.javaconda.config.MyConfigProperties;
import org.danix.javaconda.dtos.ImmutableQuote;
import org.danix.javaconda.dtos.ImmutableValue;
import org.danix.javaconda.dtos.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

@Service
public class QuoteService {

    private final RestTemplate restTemplate;

    private final MyConfigProperties properties;

    @Autowired
    public QuoteService(final RestTemplate restTemplate,
                        final MyConfigProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @HystrixCommand(
            commandKey = "getQuote",
            groupKey = "QuoteService",
            commandProperties = {
                    @HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "50")
            })
    @Cacheable("quote")
    public Quote getQuote() {
        return ImmutableQuote.builder()
                .type("Quote")
                .value(ImmutableValue.builder()
                        .id(0l)
                        .quote("This is the quote")
                        .build())
                .build();
    }

    @HystrixCommand(
            commandKey = "getSmartQuote",
            groupKey = "QuoteService",
            fallbackMethod = "getFallbackQuote",
            ignoreExceptions = {NullPointerException.class},
            commandProperties = {
                    @HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "50")
            })
    public Quote getSmartQuote(long id) {
        throw new IllegalArgumentException("The fallback should be called");
    }

    @HystrixCommand(
            commandKey = "getAsyncQuote",
            groupKey = "QuoteService",
            fallbackMethod = "getFallbackAsyncQuote",
            ignoreExceptions = {NullPointerException.class},
            commandProperties = {
                    @HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "50")
            })
    public Observable<Quote> getAsyncQuote(long id) {
        return Observable.just(
                ImmutableQuote.builder()
                        .type("Async Quote " + id)
                        .value(ImmutableValue.builder()
                                .id(0l)
                                .quote("This is an async quote")
                                .build())
                        .build());
    }

    public Quote getRemoteQuote(long id) {
        return restTemplate.getForObject(properties.getQuoters(), Quote.class);
    }

    Quote getFallbackQuote(long id) {
        return ImmutableQuote.builder()
                .type("Fallback Quote " + id)
                .value(ImmutableValue.builder()
                        .id(0l)
                        .quote("This is the fallback quote")
                        .build())
                .build();
    }

    Observable<Quote> getFallbackAsyncQuote(long id) {
        return Observable.just(
                ImmutableQuote.builder()
                        .type("Fallback Async Quote " + id)
                        .value(ImmutableValue.builder()
                                .id(0l)
                                .quote("This is an async fallback quote")
                                .build())
                        .build());
    }
}
