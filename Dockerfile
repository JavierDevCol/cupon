FROM openjdk:11
EXPOSE 8080
COPY ./build/libs/cupon-0.0.1-SNAPSHOT.jar cupon.jar
ENTRYPOINT ["java", "-jar", "/cupon.jar"]