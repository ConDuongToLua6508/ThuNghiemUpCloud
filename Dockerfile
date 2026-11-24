# Stage 1: Build mã nguồn bằng Maven
FROM maven:3.8.8-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copy pom.xml trước để tận dụng layer cache khi chưa đổi thư viện
COPY pom.xml .

# Copy source code và đóng gói .jar trực tiếp (giảm request tới Maven Central + bật retry)
COPY src ./src
RUN mvn clean package -DskipTests -B -s maven-settings.xml -Dmaven.wagon.http.retryHandler.count=3

# Stage 2: Khởi chạy ứng dụng với bộ chạy tinh gọn
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy file .jar vừa tạo từ target/ sang app.jar (tránh lệch tên phiên bản/artifactId)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]