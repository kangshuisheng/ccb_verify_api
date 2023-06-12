FROM azul/zulu-openjdk-alpine:17-latest

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

RUN ./gradlew build

EXPOSE 3399

CMD ["java", "-jar", "build/libs/ccb_verify.jar"]
