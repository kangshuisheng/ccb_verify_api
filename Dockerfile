FROM openjdk:17-jdk

RUN apt-get update && apt-get install -y findutils

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

RUN ./gradlew build

EXPOSE 3399

CMD ["java", "-jar", "build/libs/ccb_verify.jar"]
