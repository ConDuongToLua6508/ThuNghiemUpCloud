package com.backend.springboot_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.springboot_demo.model.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {
    
}
