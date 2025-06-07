FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8080
ADD quizify-backend.jar app.jar
ENTRYPOINT [ "java" , "-jar" , "/app.jar" ]