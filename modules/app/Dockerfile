FROM adoptopenjdk/openjdk8-openj9:latest
VOLUME /tmp
COPY target/*.jar cadastros-cliente-app.jar
ENTRYPOINT ["java", "-Xshareclasses:name=kerubin", "-jar", "/cadastros-cliente-app.jar"]