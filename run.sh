#!/bin/bash
mvn clean install
export DB_HOST=46.101.211.13
export DB_NAME=menuit_db
java -jar target/api-0.1.2.jar &
