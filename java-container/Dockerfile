#
# Build stage
#
#FROM --platform=linux/amd64 maven:3.8.7-eclipse-temurin-17-alpine AS build
FROM maven:3.8.7-eclipse-temurin-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
#FROM --platform=linux/amd64 eclipse-temurin:17-jre-alpine
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /home/app/target/solar-panel-checker-1.0.0-SNAPSHOT-jar-with-dependencies.jar /usr/local/lib/solar-panel-checker.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/solar-panel-checker.jar"]
