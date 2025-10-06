FROM eclipse-temurin:21-jre
WORKDIR /img
VOLUME /tmp
EXPOSE 9000
COPY ./target/hr-oauth-0.0.1-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","hr-oauth.jar"]