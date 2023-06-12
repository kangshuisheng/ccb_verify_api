FROM openjdk:11-jdk

WORKDIR /app

COPY . /app

RUN ./gradlew build

EXPOSE 3399

CMD ["java", "-jar", "build/libs/ccb_verify.jar"]
