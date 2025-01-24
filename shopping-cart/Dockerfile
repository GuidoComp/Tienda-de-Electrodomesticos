FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/shopping-cart-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_shopping-cart.jar
ENTRYPOINT ["java","-jar","/app_shopping-cart.jar"]