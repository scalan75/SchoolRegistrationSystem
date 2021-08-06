#!/bin/sh

~/WorkDirectory/utils/maven/bin/mvn clean install
docker-compose build
