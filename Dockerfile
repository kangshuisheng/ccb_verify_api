FROM openjdk:11-jdk

COPY ./build/libs/ccb_verify.jar /app/app.jar

WORKDIR /app

EXPOSE 3399

CMD ["java", "-jar", "app.jar"]
