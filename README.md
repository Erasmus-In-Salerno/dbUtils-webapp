# dbUtils-webapp

### To run the project in dev container

1. Open the dev container
2. Run the script `mvn spring-boot:run`
3. Open `https://localhost:8080` in your browser

To connect with a db management tool dev vars are:

- host: localhost
- database: postgres
- user: postgres
- password: postgres
- port: 5432

### Build and compose the project (Docker setup)

The steps to build the project as described in the `build-and-compose.sh` file:
Any of these commands can be executed independently, `build-and-compose.sh` is used just to quickly test out if building the image and running the containers works.

```sh
# Build the docker image named dbutils-webapp
mvn spring-boot:build-image -DskipTests
# Run the docker containers for the database and the app
docker compose up --build
```

Using `mvn spring-boot:build-image -DskipTests`

- we build the docker image for our project
- the name is configured in pom.xml as `dbutils-webapp`

Using `docker compose up --build`

- we run the postgres database container and the built docker image of dbuitls-webapp

After this is run you should be able to interact with the app on http://localhost:8080
