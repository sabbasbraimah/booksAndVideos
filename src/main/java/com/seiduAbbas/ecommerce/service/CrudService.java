package com.seiduAbbas.ecommerce.service;

import java.util.Set;

public interface CrudService<T, ID> {
    Iterable<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(Object object);
    void deleteById(ID id);

}
