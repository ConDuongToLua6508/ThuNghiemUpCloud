package com.backend.springboot_demo.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Nguoi {
    private String ten;
    private int tuoi;


    public Nguoi(){}
    
    public Nguoi(String ten, int tuoi) {
        this.ten = ten;
        if(tuoi > 0 ){
            this.tuoi = tuoi;
        } else {
            this.tuoi = 0;
        }
    }

    public void setTuoi(int tuoi) {
        if (tuoi >= 0)
            this.tuoi = tuoi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTen(String ten) {
            this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    
}
