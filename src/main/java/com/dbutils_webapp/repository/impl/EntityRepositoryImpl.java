package com.dbutils_webapp.repository.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import com.dbutils_webapp.model.Entity;
import com.dbutils_webapp.repository.EntityRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class EntityRepositoryImpl implements EntityRepository<Entity> {
    private final QueryRunner queryRunner;

    public EntityRepositoryImpl(DataSource dataSource) {
        this.queryRunner = new QueryRunner(dataSource);
    }


    @Override
    public Entity saveEntity(Entity entity){
        try {
            if (entity.getId() == null) {
                // Insert - Note the RETURNING clause for PostgreSQL
                String sql = "INSERT INTO entities (name) VALUES (?) RETURNING id";
                Long generatedId = queryRunner.query(sql,
                    new ScalarHandler<>(),
                    entity.getName()
                );
                entity.setId(generatedId);
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
