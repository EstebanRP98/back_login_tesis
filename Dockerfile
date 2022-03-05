FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=target/cuadros-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} cuadros-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","cuadros-0.0.1-SNAPSHOT.jar"]