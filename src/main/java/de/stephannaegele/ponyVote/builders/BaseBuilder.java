package de.stephannaegele.ponyVote.builders;

public interface BaseBuilder {
    BaseBuilder  withRandomId();
    BaseBuilder withId(Long id);
    Object get();
}
