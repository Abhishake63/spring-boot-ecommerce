FROM eclipse-temurin:17-alpine
RUN mkdir /opt/app
COPY target/*.jar opt/app/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
