FROM openjdk:8
#ARG JAR_FILE=target/*.jar
#ADD target/*.jar app.jar
#ENV JAVA_OPTS=""
COPY ./microservice.produits/dockerfile-0.0.1-SNAPSHOT.jar dockerfile-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "dockerfile-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java","-jar","/app.jar"]

