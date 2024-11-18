package com.dbutils_webapp.repository.impl;

import com.dbutils_webapp.model.Animal;
import com.dbutils_webapp.repository.EntityRepository;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AnimalRepositoryImpl implements EntityRepository<Animal> {
    private final QueryRunner queryRunner;

    public AnimalRepositoryImpl(DataSource dataSource) {
        this.queryRunner = new QueryRunner(dataSource);
    }


    @Override
    public Animal saveEntity(Animal entity) {
        try {
            if (entity.getId() == null) {
                // Insert - Note the RETURNING clause for PostgreSQL
                String sql = "INSERT INTO animals (name, age, species) VALUES (?, ?, ?) RETURNING id";
                Long generatedId = queryRunner.query(sql,
                        new ScalarHandler<>(),
                        entity.getName(),
                        entity.getAge(),
                        entity.getSpecies()
                );
                entity.setId(generatedId);
            } else {
                // Update
                String sql = "UPDATE animals SET name = ?, age = ?, species = ? WHERE id = ?";
                queryRunner.update(sql, entity.getName(), entity.getAge(), entity.getSpecies(), entity.getId());
            }
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving person", e);
        }
    }

    @Override
    public List<Animal> findAll() {
        String sql = "SELECT * FROM animals";
        try{
            List<Animal> animals = queryRunner.query(sql, new BeanListHandler<>(Animal.class));
            return animals;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving person", e);
        }
    }

    @Override
    public boolean deleteEntity(Animal entity) {
        return deleteEntity(entity.getId());
    }

    @Override
    public boolean deleteEntity(Long id) {
        String sql = "DELETE FROM animals WHERE id = ?;";
        try{
            int deleted = queryRunner.update(sql, id);
            return deleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving person", e);
        }
    }
}