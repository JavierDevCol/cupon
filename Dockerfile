FROM openjdk:11
EXPOSE 8080
ADD ./build/libs/cupon.jar
ENTRYPOINT ["java", "-jar", "/cupon.jar"]