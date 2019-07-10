FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar cadastros-cliente-app.jar
ENTRYPOINT ["java","-jar","/cadastros-cliente-app.jar"]