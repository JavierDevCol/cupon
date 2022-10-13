FROM openjdk:11
EXPOSE 8080
ADD ./build/libs/cupon-0.0.1-SNAPSHOT.jar cupon.jar
ENTRYPOINT ["java", "-jar", "/cupon.jar"]