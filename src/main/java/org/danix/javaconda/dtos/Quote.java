package org.danix.javaconda.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import static org.immutables.value.Value.Immutable;

@Immutable
@JsonSerialize(as = ImmutableQuote.class)
@JsonDeserialize(as = ImmutableQuote.class)
public interface Quote {

    String name();

    @JsonProperty("value")
    String value();
}
