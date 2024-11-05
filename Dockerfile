FROM openjdk:17-jdk-slim
WORKDIR /app
RUN ls -la
COPY ./build/libs/said-market-1.0.jar /app/app_market.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_market.jar"]


