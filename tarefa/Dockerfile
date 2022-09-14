FROM maven:3.6.3-openjdk-8 as build

WORKDIR /usr/src/app

COPY . .
RUN mvn clean package

FROM openjdk:8-jdk-alpine as deploy

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=/usr/src/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]