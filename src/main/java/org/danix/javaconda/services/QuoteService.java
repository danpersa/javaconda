package org.danix.javaconda.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.danix.javaconda.dtos.ImmutableQuote;
import org.danix.javaconda.dtos.Quote;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class QuoteService {

    @HystrixCommand(
            commandKey = "getQuote",
            groupKey = "QuoteService",
            commandProperties = {
                    @HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "50")
            })
    public Quote getQuote() {
        return ImmutableQuote.builder()
                .name("Quote")
                .value("This is the quote")
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
                        .name("Async Quote " + id)
                        .value("This is an async quote")
                        .build());
    }

    Quote getFallbackQuote(long id) {
        return ImmutableQuote.builder()
                .name("Fallback Quote " + id)
                .value("This is a fallback quote")
                .build();
    }

    Observable<Quote> getFallbackAsyncQuote(long id) {
        return Observable.just(
                ImmutableQuote.builder()
                        .name("Fallback Async Quote " + id)
                        .value("This is a fallback async quote")
                        .build());

    }
}
