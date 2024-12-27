FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
LABEL authors="Vaibhav"

COPY --from=build /app/target/chat-app-backend-0.0.1-SNAPSHOT.jar ./app/chat-app-backend-0.0.1-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "chat-app-backend-0.0.1-SNAPSHOT.jar"]
