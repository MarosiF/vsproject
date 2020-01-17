FROM openjdk:8
COPY target/*.jar eureka-service.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-service.jar"]

#-> pom <finalName>eureka-service</finalName>