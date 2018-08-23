package org.danix.javaconda.dtos;

import static org.immutables.value.Value.Immutable;

@Immutable
public interface Quote {

    String value();

    String name();
}
