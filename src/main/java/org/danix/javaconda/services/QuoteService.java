package org.danix.javaconda.services;

import org.danix.javaconda.dtos.Quote;
import org.springframework.stereotype.Service;
import org.danix.javaconda.dtos.ImmutableQuote;

@Service
public class QuoteService {

    public Quote getQuote() {
        return ImmutableQuote.builder()
                .name("Quote")
                .value("This is the quote")
                .build();
    }
}
