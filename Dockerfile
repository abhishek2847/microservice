FROM java:8
EXPOSE 8811
ADD /target/MicroserviceDemo-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
