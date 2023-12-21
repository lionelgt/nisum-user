FROM openjdk:17

COPY application/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT java -jar app.jar
