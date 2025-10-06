FROM eclipse-temurin:21-jre
WORKDIR /img
VOLUME /tmp
EXPOSE 8082
COPY ./target/hr-user-0.0.1-SNAPSHOT.jar hr-user.jar
ENTRYPOINT ["java","-jar","hr-user.jar"]