FROM amazoncorretto:17-alpine-jdk
COPY target/insurance-*.jar insurance.jar
ENTRYPOINT ["java", "-jar", "/insurance.jar"] 
