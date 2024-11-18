CREATE TABLE IF NOT EXISTS entities (
                                        id BIGSERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL
    );
CREATE TABLE IF NOT EXISTS animals (
                                        id BIGSERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        age int NOT NULL,
                                        species VARCHAR(255) NOT NULL
    );
