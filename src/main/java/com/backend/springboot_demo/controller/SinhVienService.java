package com.backend.springboot_demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.springboot_demo.repository.SinhVienRepository;
import com.backend.springboot_demo.dto.SinhVienCreationDTO;
import com.backend.springboot_demo.exception.ResourceNotFoundException;
import com.backend.springboot_demo.model.SinhVien;

@Service
public class SinhVienService {
    @Autowired

    private SinhVienRepository repository;

    public List<SinhVien> getAll(){
        return repository.findAll();
    }

    public void add(SinhVienCreationDTO dto){
        SinhVien sv = new SinhVien();

        BeanUtils.copyProperties(dto, sv);
        repository.save(sv);
    }

    public SinhVien getById(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên có ID = " + id));
    }

    public SinhVien update(Integer id, SinhVien updatedSinhVien) {
        // Tìm xem sinh viên có tồn tại trong DB không
        return repository.findById(id).map(sv -> {
            // Nếu có, thực hiện map (cập nhật) các trường thông tin mới
            sv.setTen(updatedSinhVien.getTen());
            sv.setTuoi(updatedSinhVien.getTuoi());
            sv.setMaSV(updatedSinhVien.getMaSV());
            sv.setDiemTB(updatedSinhVien.getDiemTB());
            sv.setMail(updatedSinhVien.getMail());
            // Lưu đè lại vào database
            return repository.save(sv);
        }).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên có ID = " + id));
    }

    public boolean delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new ResourceNotFoundException("Không tìm thấy sinh viên có ID = " + id);
        }
    }    
}
