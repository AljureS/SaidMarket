# Usar la imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR desde el directorio de build local al contenedor
COPY ./build/libs/said-market-1.0.jar /app/app_market.jar

# Copiar los archivos SQL al contenedor
COPY ./1_schema.sql /app/sql-scripts/1_schema.sql
COPY ./2_data.sql /app/sql-scripts/2_data.sql

# Instalar el cliente de PostgreSQL para ejecutar los archivos SQL
RUN apt-get update && apt-get install -y postgresql-client && rm -rf /var/lib/apt/lists/*

# Crear un volumen para la persistencia de datos (este volumen será persistente en entornos compatibles, como Docker Compose)
VOLUME /app/sql-scripts

# Exponer el puerto 8080 para la aplicación
EXPOSE 8080

# Comando de entrada para inicializar la base de datos y luego iniciar la aplicación
ENTRYPOINT ["sh", "-c", "PGPASSWORD=$POSTGRES_PASSWORD psql -h localhost -U $POSTGRES_USER -d $POSTGRES_DB -f /app/1_schema.sql && PGPASSWORD=$POSTGRES_PASSWORD psql -h localhost -U $POSTGRES_USER -d $POSTGRES_DB -f /app/2_data.sql && java -jar app_market.jar"]


