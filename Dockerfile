FROM openjdk:17-jdk-slim
RUN ls -la build/libs/
COPY build/libs/said-market-1.0.jar app_market.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_market.jar"]

