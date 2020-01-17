FROM openjdk:8
COPY target/*.jar product-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "product-service.jar"]

#-> pom <finalName>product-service</finalName>