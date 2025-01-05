#!/bin/sh

# Build the docker image named dbutils-webapp
mvn spring-boot:build-image -DskipTests
# Run the docker containers for the database and the app
docker compose up --build
