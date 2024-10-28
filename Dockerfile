FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/said-market-1.0.jar
COPY ${JAR_FILE} app_market.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_market.jar"]
