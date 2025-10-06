FROM eclipse-temurin:21-jre
WORKDIR /img
VOLUME /tmp
EXPOSE 8761
COPY ./target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
ENTRYPOINT ["java","-jar","hr-eureka-server.jar"]