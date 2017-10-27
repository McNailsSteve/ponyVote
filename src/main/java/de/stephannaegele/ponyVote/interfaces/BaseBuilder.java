package de.stephannaegele.ponyVote.interfaces;

public interface BaseBuilder {
    BaseBuilder  withRandomId();
    BaseBuilder withId(Long id);
    Object get();
}
