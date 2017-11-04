package de.stephannaegele.ponyVote.views;

public interface BaseView<T> {
    public T mapTo();
    public void mapFrom(T object);
}
