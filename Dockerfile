# Stage 1: Build mã nguồn bằng Maven
FROM maven:3.8.8-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copy pom.xml và maven-settings.xml
COPY pom.xml .
COPY maven-settings.xml .

# Copy source code và đóng gói .jar
COPY src ./src
RUN mvn clean package -DskipTests -B -s maven-settings.xml -Dmaven.wagon.http.retryHandler.count=3

# Stage 2: Khởi chạy ứng dụng với bộ chạy tinh gọn
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]