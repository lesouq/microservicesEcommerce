FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]