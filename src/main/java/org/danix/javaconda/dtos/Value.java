package org.danix.javaconda.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@org.immutables.value.Value.Immutable
@JsonSerialize(as = ImmutableValue.class)
@JsonDeserialize(as = ImmutableValue.class)
public interface Value {

    @JsonProperty("id")
    long id();

    @JsonProperty("quote")
    String quote();
}
