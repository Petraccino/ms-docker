FROM eclipse-temurin:21-jre
WORKDIR /img
VOLUME /tmp
EXPOSE 8081
COPY ./target/hr-payroll-0.0.1-SNAPSHOT.jar hr-payroll.jar
ENTRYPOINT ["java","-jar","hr-payroll.jar"]