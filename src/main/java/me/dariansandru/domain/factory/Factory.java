package me.dariansandru.domain.factory;

public interface Factory<T> {
    public T getObject(String object);
}
