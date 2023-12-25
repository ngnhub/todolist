# Kotlin To-Do List Application

## Introduction
This To-Do List application is a personal project I developed to familiarize myself with Kotlin. It's a simple tool that allows users to create, read, and delete items from their to-do list.

## Features
- **Create Tasks:** Users can add new tasks to their to-do list.
- **Read Tasks:** Users can view all the tasks in their list.
- **Delete Tasks:** Users can remove tasks that they have completed or no longer need.

## Getting Started
To get started with this application, clone the repository to your local machine and ensure you have required setup: 
* JDK 17
* Docker
### Run
Open your terminal and run following commands: 
* `cd /path/to/todolist`
* `docker-compose up -d` (running MySQL db locally)
* `./gradlew build`
* `java -jar build/libs/todolist-0.0.1-SNAPSHOT.jar`

## Access Points
- **Swagger UI:** Test and interact with the API endpoints through Swagger UI at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
- **User Interface:** Manage your to-do list through a basic UI at [http://localhost:8080](http://localhost:8080).

## Technology Stack
This application was developed using:
- **Language:** Kotlin 1.9.21
- **Framework:** Spring Boot 3.x
- **Database:** MySQL
- **Containerization:** Docker
- **Testing:** MockK, Jupiter, Assertj
