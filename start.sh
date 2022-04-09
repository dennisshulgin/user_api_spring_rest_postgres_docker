#!/bin/bash

set -e

cd ./user_api
mvn package
cd ../client
mvn package
cd ..
docker-compose build
docker-compose up
