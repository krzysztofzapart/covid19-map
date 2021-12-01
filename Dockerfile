FROM openjdk:17
ADD target/covid19-map-0.0.1-SNAPSHOT.jar covid19map.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","covid19map.jar"]
