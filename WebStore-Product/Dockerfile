
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package -Dmaven.test.skip


FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY --from=MAVEN_BUILD /tmp/target/*.jar WebStore-Product-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/WebStore-Product-0.0.1-SNAPSHOT.jar"]



#FROM maven:3.8.2-jdk-11-slim
#WORKDIR /usr/src/app
#COPY . /usr/src/app
#RUN chmod +x ./wait_for_it.sh
#RUN mvn package -Dmaven.test.skip
#CMD [ "sh", "-c", "mvn spring-boot:run" ]
#
##FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
##COPY pom.xml /tmp/
##COPY src /tmp/src/
##WORKDIR /tmp/
##RUN mvn package -Dmaven.test.skip
##
##
##FROM openjdk:8-jdk-alpine
##
##
##ARG JAR_FILE=target/*.jar
##COPY --from=MAVEN_BUILD /tmp/target/*.jar WebStore-Product-0.0.1-SNAPSHOT.jar
##ENTRYPOINT ["java","-jar","/WebStore-Product-0.0.1-SNAPSHOT.jar"]