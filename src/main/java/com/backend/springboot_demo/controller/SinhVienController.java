package com.backend.springboot_demo.controller;

import com.backend.springboot_demo.dto.SinhVienCreationDTO;
import com.backend.springboot_demo.model.SinhVien;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/SinhViens") 
public class SinhVienController {
    @Autowired
    private SinhVienService SinhVienService;

    // 1. READ: Lấy danh sách sinh viên
    // Cú pháp: GET http://localhost:8080/api/SinhViens
    @GetMapping
    public List<SinhVien> getAllSinhViens(){
        return SinhVienService.getAll();
    }

    // 2. READ: Lấy sinh viên theo ID
    // Cú pháp: GET http://localhost:8080/api/SinhViens/1
    @GetMapping("/{id}")
    public SinhVien SinhViengetById(@PathVariable Integer id){
        return SinhVienService.getById(id);
    }

    // 3. CREATE: Thêm sinh viên mới
    // Cú pháp: POST http://localhost:8080/api/SinhViens (Kèm JSON Body)
    @PostMapping
    public ResponseEntity<String> createSinhVien(@Valid @RequestBody SinhVienCreationDTO newSinhVien) {
        SinhVienService.add(newSinhVien);
        return ResponseEntity.status(HttpStatus.CREATED).body("Lưu sinh viên thành công!");
    }

    // 4. UPDATE: Cập nhật thông tin
    // Cú pháp: PUT http://localhost:8080/api/SinhViens/1 (Kèm JSON Body)
    @PutMapping("/{id}")
    public SinhVien updateStudent(@PathVariable Integer id, @RequestBody SinhVien updatedSinhVien) {
       return SinhVienService.update(id, updatedSinhVien);
    }

    // 5. DELETE: Xóa sinh viên
    // Cú pháp: DELETE http://localhost:8080/api/SinhViens/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSinhVien(@PathVariable Integer id) {
        SinhVienService.delete(id);
        return ResponseEntity.ok("Đã xóa thành công sinh viên có ID: " + id);
    }
}
