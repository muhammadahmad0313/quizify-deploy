FROM eclipse-temurin:21-jdk-alpine
ENV PORT=8080
EXPOSE ${PORT}
ADD quizify-backend.jar app.jar
ENTRYPOINT [ "java", "-jar", "-Dserver.port=${PORT}", "/app.jar" ]