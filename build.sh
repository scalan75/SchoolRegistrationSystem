#!/bin/sh

#~/WorkDirectory/utils/maven/bin/mvn clean install
mvn clean install
docker-compose build
