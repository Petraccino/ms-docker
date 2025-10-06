FROM eclipse-temurin:21-jre
WORKDIR /img
VOLUME /tmp
EXPOSE 8765
COPY ./target/hr-api-gateway-0.0.1-SNAPSHOT.jar hr-api-gateway.jar
ENTRYPOINT ["java","-jar","hr-api-gateway.jar"]