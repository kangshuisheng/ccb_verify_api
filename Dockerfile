FROM adoptopenjdk:17-jdk-hotspot-alpine

COPY ./build/libs/ccb_verify.jar /app/app.jar

WORKDIR /app

EXPOSE 3399

CMD ["java", "-jar", "app.jar"]
