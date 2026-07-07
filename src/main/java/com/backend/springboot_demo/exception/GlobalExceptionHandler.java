package com.backend.springboot_demo.exception;

import com.backend.springboot_demo.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Đánh dấu lớp này chuyên xử lý lỗi cho các RestController
public class GlobalExceptionHandler {

    // 1. Xử lý lỗi "Không tìm thấy tài nguyên" (Do chúng ta tự định nghĩa)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 2. Xử lý lỗi Validation (Chương 1) - Bắt lỗi khi dữ liệu gửi lên sai định dạng
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        // Lấy thông báo lỗi đầu tiên mà chúng ta đã cấu hình ở thuộc tính DTO (ví dụ: "Email không đúng định dạng")
        String defaultMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), defaultMessage);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 3. Xử lý tất cả các lỗi không xác định còn lại (Lỗi hệ thống, lỗi crash code)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        // Giấu lỗi hệ thống, chỉ trả về thông báo chung chung cho an toàn bảo mật
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Hệ thống có lỗi xảy ra, vui lòng thử lại sau.");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
