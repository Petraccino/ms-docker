FROM eclipse-temurin:21-jre
WORKDIR /img
VOLUME /tmp
EXPOSE 8083
COPY ./target/hr-worker-0.0.1-SNAPSHOT.jar hr-worker.jar
ENTRYPOINT ["java","-jar","hr-worker.jar"]