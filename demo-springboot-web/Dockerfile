FROM adoptopenjdk/openjdk11:latest
RUN echo `whoami`
RUN mkdir -p /opt/app/logs
COPY ./target/spring-boot-demo.jar /opt/app
expose 7777
CMD ["java", "-jar", "/opt/app/spring-boot-demo.jar"]
