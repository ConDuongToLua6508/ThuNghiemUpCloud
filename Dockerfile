# Bước 1: Chọn Base Image chứa sẵn môi trường Java 17 thu nhỏ
FROM eclipse-temurin:17-jdk-alpine

# Bước 2: Thiết lập thư mục làm việc bên trong Container
WORKDIR /app

# Bước 3: Copy file .jar từ máy thật vào bên trong thư mục /app của Container
COPY target/springboot-demo-0.0.1-SNAPSHOT.jar app.jar

# Bước 4: Ra lệnh cho Container mở cổng 8080 để hứng Request
EXPOSE 8080

# Bước 5: Câu lệnh mặc định để khởi chạy ứng dụng Java khi Container bật
ENTRYPOINT ["java", "-jar", "app.jar"]