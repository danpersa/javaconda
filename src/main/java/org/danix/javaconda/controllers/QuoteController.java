package org.danix.javaconda.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.danix.javaconda.dtos.Quote;
import org.danix.javaconda.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(final QuoteService quoteService) {
        this.quoteService = quoteService;
    }


    @ApiOperation(value = "Finds a Quote by id")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Quote quote(@PathVariable("id")
                       @ApiParam(value = "The id of the quote", example = "23", required = true) final long id) {
        return quoteService.getQuote();
    }

    @ApiOperation(value = "Finds a Smart Quote by id")
    @RequestMapping(path = "/{id}/smart", method = RequestMethod.GET)
    public Quote smartQuote(@PathVariable("id")
                            @ApiParam(value = "The id of the smart quote", example = "23", required = true) final long id) {
        return quoteService.getSmartQuote(id);
    }
}
