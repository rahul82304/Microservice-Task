FROM openjdk:23-jdk-slim
WORKDIR /app
COPY build/libs/micro-collector-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java","-jar","/app.jar"]