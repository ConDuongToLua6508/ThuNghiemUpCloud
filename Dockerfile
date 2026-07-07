# Stage 1: Build mã nguồn bằng Maven
FROM maven:3.8.8-eclipse-temurin-17-alpine AS build
WORKDIR /app
# Copy toàn bộ mã nguồn vào container build
COPY . .
# Chạy lệnh build sinh file jar bên trong container (bỏ qua chạy thử test)
RUN mvn clean package -DskipTests

# Stage 2: Khởi chạy ứng dụng với bộ chạy tinh gọn
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Lấy file jar đã build xong từ Stage 1 sang Stage 2
COPY --from=build /app/target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]