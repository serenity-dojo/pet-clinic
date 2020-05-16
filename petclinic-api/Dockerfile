#
# BUILD WITH THE FOLLOWING COMMAND:
# docker build -t serenitydojo/serenity-petclinic-api .
#
# START A CONTAINER RUNNING THIS BUILD WITH THE FOLLOWING COMMAND:
# docker run -p 9966:9966 --detach --name api serenitydojo/serenity-petclinic-ui
#
FROM openjdk:12-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petclinic-server.jar
EXPOSE 9966
ENTRYPOINT ["java","-jar","/petclinic-server.jar"]


