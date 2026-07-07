package com.backend.springboot_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "qlsv")
public class SinhVien extends Nguoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "maSV")
    private String maSV; 
    private double diemTB;
    private String mail;
    
    // Constructor rỗng (Bắt buộc cho Spring Boot)
    public SinhVien() {
        super();
    }
    
    // Constructor có tham số
    public SinhVien(Integer id, String ten, int tuoi, String maSV, double diemTB, String mail) {
        super(ten, tuoi); // Đẩy ten và tuoi lên class Nguoi xử lý
        this.id = id;
        this.maSV = maSV;
        this.diemTB = diemTB;
        this.mail = mail;
    }

    // --- GETTER & SETTER CHUẨN ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public double getDiemTB() {
        return diemTB;
    }

    // Đã sửa chữ 'd' thành 'D'
    public void setDiemTB(double diemTB) {
        if(diemTB < 0 || diemTB > 10) {
            throw new IllegalArgumentException("Diem khong hop le");
        }    
        this.diemTB = diemTB;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}