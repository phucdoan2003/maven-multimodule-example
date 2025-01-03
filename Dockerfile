FROM openjdk:23-jdk

COPY ./main/target/main-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]