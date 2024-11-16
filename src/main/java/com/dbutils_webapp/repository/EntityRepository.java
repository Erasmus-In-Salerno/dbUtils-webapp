package com.dbutils_webapp.repository;

public interface EntityRepository<T> {
    public T saveEntity(T entity);
    //public List<T> findAll();
    //public boolean deleteEntity(T entity);
    //public boolean deleteEntity(int id);
}
