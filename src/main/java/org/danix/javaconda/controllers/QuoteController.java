package org.danix.javaconda.controllers;

import org.danix.javaconda.dtos.Quote;
import org.danix.javaconda.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(final QuoteService quoteService) {
        this.quoteService = quoteService;
    }


    @RequestMapping(path = "/{id}")
    public Quote quote(@PathVariable("id") final long id) {
        return quoteService.getQuote();
    }
}
