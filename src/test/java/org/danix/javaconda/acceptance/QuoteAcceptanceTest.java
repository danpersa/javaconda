package org.danix.javaconda.acceptance;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class QuoteAcceptanceTest extends BaseAcceptanceTest {

    @Test
    public void testGetQuote() throws Exception {
        mockMvc.perform(
                get("/quotes/1/remote")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.type").value("success"))
                .andExpect(jsonPath("$.value.id").value(5))
                .andExpect(jsonPath("$.value.quote").value("Spring Boot solves this problem."));
    }
}
