package com.dbutils_webapp.repository;

import java.util.List;

public interface EntityRepository<T> {
    T saveEntity(T entity);
    List<T> findAll();
    boolean deleteEntity(T entity);
    boolean deleteEntity(int id);
}
