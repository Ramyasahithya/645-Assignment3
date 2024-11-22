# Ramyasahithya Magani - G01425752
# Arsitha Sathu - G01445215
# Athiksha Venkannagari - G01461169
# Sreshta Kosaraju - G01460468

# Dockerfile is used to create a Docker image for the Survey form application.
# It uses OpenJDK 17 as the base image and run the application as a JAR file.

FROM openjdk:17-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/surveyForm-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
