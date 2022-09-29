FROM openjdk:17-jdk-slim
COPY target/task.jar task.jar
ENTRYPOINT ["java","-jar","/task.jar"]
ENV spring_profiles_active=dev