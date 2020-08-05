FROM openjdk:8
ADD target/gateway.serve-0.0.1-SNAPSHOT.jar gateway.server-0.0.1-SNAPSHOT.jar
EXPOSE 8808
ENTRYPOINT ["java", "-jar", "gateway.server-0.0.1-SNAPSHOT.jar"]