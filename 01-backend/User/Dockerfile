FROM openjdk:8
COPY target/*.jar user-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "user-service.jar"]

#-> pom <finalName>user-service</finalName>