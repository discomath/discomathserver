#!/bin/bash

./mvnw spring-boot:run -Dspring-boot.run.arguments=--allowLocalhost=true,--management.endpoints.web.cors.allowed-origins=http://localhost:8081,--management.endpoints.web.cors.allowed-methods=GET

