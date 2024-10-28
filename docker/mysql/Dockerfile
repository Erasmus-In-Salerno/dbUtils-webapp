# docker/mysql/Dockerfile
FROM mysql:8.0

RUN apt-get update && apt-get install -y \
    vim \
    && rm -rf /var/lib/apt/lists/*

COPY conf/my.cnf /etc/mysql/conf.d/

HEALTHCHECK --interval=30s --timeout=3s \
  CMD mysqladmin ping -h localhost -u root -p$MYSQL_ROOT_PASSWORD || exit 1

WORKDIR /var/lib/mysql