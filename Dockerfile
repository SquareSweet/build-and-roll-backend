FROM openjdk:17.0.2-jdk-slim-buster
LABEL maintainer="your_email@example.com"
VOLUME /main-app
ADD buildandroll-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
