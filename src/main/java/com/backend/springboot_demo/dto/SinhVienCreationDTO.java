package com.backend.springboot_demo.dto;

import jakarta.validation.constraints.*;

public class SinhVienCreationDTO {
        
    @NotBlank(message = "Tên sinh viên không được để trống")
    @Size(min = 2, max = 50, message = "Tên phải từ 2 đến 50 ký tự")
    private String ten;

    @NotNull(message = "Tuoi KO DC DE TRONG")
    @Min(value = 18, message = "Sinh viên phải từ 18 tuổi trở lên")
    @Max(value = 100, message = "Tuổi không hợp lệ")
    private Integer tuoi;

    @NotBlank(message = "MSSV KO DC DE TRONG")
    private String maSV;

    @NotNull(message = "DIEMTB KO DC DE TRONG")
    @Min(value = 0, message = "DIEMTB PHAI >= 0")
    @Max(value = 10, message = "DIEMTB PHAI <= 10")
    private Double diemTB;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String mail;


    public void setTuoi(Integer tuoi) {
        if (tuoi >= 0)
            this.tuoi = tuoi;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTen(String ten) {
            this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public Double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Double diemTB) {  
        this.diemTB = diemTB;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
