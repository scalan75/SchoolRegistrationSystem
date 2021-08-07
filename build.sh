#!/bin/sh

#~/WorkDirectory/utils/maven/bin/mvn clean install
./mvnw clean install
docker-compose build
