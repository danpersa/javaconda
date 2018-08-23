package org.danix.javaconda.dtos;

import java.util.Optional;
import java.util.Set;
import org.immutables.value.Value;

@Value.Immutable
abstract class Book {
    abstract String getName();
    abstract Set<String> getTags();
    abstract Optional<String> getDescription();
}
