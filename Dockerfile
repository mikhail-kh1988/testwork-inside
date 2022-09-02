FROM openjdk:11-jdk-oracle
COPY build/libs/testwork-0.0.3.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]