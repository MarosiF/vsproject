FROM openjdk:8
COPY target/*.jar hystrix-service.jar
EXPOSE 9010
ENTRYPOINT ["java", "-jar", "hystrix-service.jar"]

#-> pom <finalName>hystrix-service</finalName>