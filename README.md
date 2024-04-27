# Spring Boot Ecommerce Task

Welcome to the E-commerce Application Development Challenge!

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Build With Docker](#build-with-docker)

## Introduction

Here, I am developing an E-commerce Application as described in the task. The 5 API Endpoints I am mainly focusing on, in this task are:

1. Get Wish List
2. Get Total Sale Amount for the Current Day
3. Get Max Sale Day within a Time Range
4. Get Top 5 Selling Items of All Time
5. Get Top 5 Selling Items of the Last Month

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (version 17 or higher)
- Maven build tool installed
- PostgreSQL installed

## Getting Started

To get a local copy of the project up and running, follow these steps:

1. Clone the repository

   ```sh
   git clone https://github.com/Abhishake63/spring-boot-ecommerce.git
   ```

2. Change directory

   ```sh
   cd spring-boot-ecommerce
   ```

3. Create a user named 'dynamic' with password 'dynamic'

   ```sh
   sudo -u postgres createuser --pwprompt dynamic
   ```

4. Create a database named 'ecommerce' and give permissions to the user 'dynamic'

   ```sh
   sudo -u postgres createdb -O dynamic ecommerce
   sudo -u postgres psql -c 'GRANT ALL ON DATABASE ecommerce TO dynamic;'
   psql -U dynamic -h localhost -d ecommerce -f db_prepare.sql
   ```

5. Build the project and Run the application

   ```sh
   mvn spring-boot:run
   ```

## Build with Docker

### Build the WAR file

```bash
mvn clean package
```

### Build the Docker image

```bash
docker build -t ecommerce .
```

### Run the Docker container

```bash
docker run -d -p 8080:8080 ecommerce:latest
```

### Check Container Logs

If the project ran successfully, you can go to [Swagger UI](http://localhost:8080/swagger/ui) & test the endpoints. If you face any issue with postgres connection, please check the properties file and change datasource url accordingly for docker. 