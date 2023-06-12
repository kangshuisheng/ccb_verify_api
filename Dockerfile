FROM openjdk:17-jdk

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

RUN ./gradlew build

EXPOSE 3399

CMD ["java", "-jar", "build/libs/ccb_verify.jar"]
