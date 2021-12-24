FROM openjdk:11

EXPOSE 8080

WORKDIR /app

COPY /target/main-0.0.1-SNAPSHOT.jar /app/main-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "/app/main-0.0.1-SNAPSHOT.jar" ]