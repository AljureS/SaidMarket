# Usar la imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR desde el directorio de build local al contenedor
COPY ./build/libs/said-market-1.0.jar /app/app_market.jar

# Comando para verificar el contenido del directorio de trabajo (opcional, para diagnóstico)
RUN ls -la

# Exponer el puerto 8080 para la aplicación
EXPOSE 8080

# Configurar el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app_market.jar"]



