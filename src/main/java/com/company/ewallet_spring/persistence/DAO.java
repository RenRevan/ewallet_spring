package com.company.ewallet_spring.persistence;

import java.util.List;

public interface DAO<T> {

    T create(T t);

    T update(T t);

    void delete(T t);

    T get(int id);

    List<T> getAll();

}
