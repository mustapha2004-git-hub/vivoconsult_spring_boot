package com.vivoconsult.vivoconsultWebsite;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "services_table")
public class ServicesContent {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "mediumblob")
    private byte[] cardImg;
    private String h3Service;
    @Column(columnDefinition = "TEXT")
    private String Service;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public byte[] getCardImg() {
        return cardImg;
    }
    public void setCardImg(byte[] cardImg) {
        this.cardImg = cardImg;
    }
    public String getH3Service() {
        return h3Service;
    }
    public void setH3Service(String h3Service) {
        this.h3Service = h3Service;
    }
    public String getService() {
        return Service;
    }
    public void setService(String service) {
        Service = service;
    }

    public String generateBase64Image() {
        if (cardImg != null && cardImg.length > 0) {
            return Base64.getEncoder().encodeToString(cardImg);
        }
        return "";
    }


}
