FROM openjdk:11
ARG JAR_FILE=target/userms.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","/app.jar"]