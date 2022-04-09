#!/bin/bash

set -e

docker-compose down
docker rmi user_api_spring_rest_postgres_docker_db:latest
