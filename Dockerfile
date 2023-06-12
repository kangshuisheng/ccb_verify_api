FROM openjdk:17-jdk

WORKDIR /app

COPY build/libs/ccb_verify.jar ./app.jar

EXPOSE 3399

CMD ["java", "-jar", "app.jar"]
