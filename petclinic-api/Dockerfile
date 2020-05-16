#
# BUILD WITH THE FOLLOWING COMMAND:
# docker build -t serenitydojo/serenity-petclinic-api .
#
# START A CONTAINER RUNNING THIS BUILD WITH THE FOLLOWING COMMAND:
# docker run -p 9966:9966 --detach --name api serenitydojo/serenity-petclinic-api
#

#
# CREATE AN IMAGE TO BUILD THE SPRING-BOOT JAR
#
FROM maven:3.6.3-openjdk-11 AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

#
# BUILD AN IMAGE TO RUN THE SPRING-BOOT EXECUTABLE JAR
#
FROM openjdk:12-jdk-alpine
FROM openjdk:12-jdk-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar target/

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petclinic-api.jar
EXPOSE 9966
ENTRYPOINT ["java","-jar","/petclinic-api.jar"]


