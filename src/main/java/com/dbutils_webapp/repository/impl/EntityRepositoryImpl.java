package com.dbutils_webapp.repository.impl;

import org.springframework.stereotype.Repository;

import com.dbutils_webapp.model.Entity;
import com.dbutils_webapp.repository.EntityRepositoryInterface;

@Repository
public class EntityRepositoryImpl implements EntityRepositoryInterface<Entity> {
    private final QueryRunner queryRunner;

    public PersonRepositoryImpl(DataSource dataSource) {
        this.queryRunner = new QueryRunner(dataSource);
    }


    @Override
    public Entiy saveEntity(Entity entity){
        try {
            if (entity.getId() == null) {
                // Insert - Note the RETURNING clause for PostgreSQL
                String sql = "INSERT INTO entities (name) VALUES (?) RETURNING id";
                Long generatedId = queryRunner.query(sql,
                    new ScalarHandler<Long>(),
                    person.getName()
                );
                person.setId(generatedId);
            } else {
                // Update
                String sql = "UPDATE persons SET name = ? WHERE id = ?";
                queryRunner.update(sql, entity.getName(), entity.getId());
            }
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving person", e);
        }
    }
    
}
