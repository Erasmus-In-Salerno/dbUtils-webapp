package com.dbutils_webapp.repository;

import java.util.List;

public interface EntityRepositoryInterface<T> {
    public T saveEntity(T entity);
    //public List<T> findAll();
    //public boolean deleteEntity(T entity);
    //public boolean deleteEntity(int id);
}
