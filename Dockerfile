FROM openjdk:11.0.14-jre
WORKDIR opt/
COPY target/*.jar .
ENTRYPOINT ["java", "-DREDIS_HOST=localhost", "-DREDIS_PORT=6379", "-jar", "java_rest_api_to_redis-1.0-SNAPSHOT.jar"]