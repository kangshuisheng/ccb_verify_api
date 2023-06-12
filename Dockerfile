FROM openjdk:11-jdk

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 3399

CMD ["java", "-jar", "app.jar"]
