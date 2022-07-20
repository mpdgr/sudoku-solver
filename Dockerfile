FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY src/main/resources/log/logback.xml src/main/resources/log/
COPY src/main/resources/log/controller.log src/main/resources/log/
COPY src/main/resources/static/database/sudoku_base3.csv src/main/resources/static/database/
USER root
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]