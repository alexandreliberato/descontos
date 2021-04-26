FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY /target /usr/bin/app

WORKDIR /usr/bin/app

ENTRYPOINT ["java", "-jar", "app-1-SNAPSHOT-jar-with-dependencies.jar"]
