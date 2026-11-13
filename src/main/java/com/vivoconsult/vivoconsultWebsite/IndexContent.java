package com.vivoconsult.vivoconsultWebsite;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "index_table")
public class IndexContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String h1;
    private String homeDescription;

    @Column(columnDefinition = "mediumblob")
    private byte[] aboutPhoto;

    private String h2;
    private String h2Description;
    
    @Column(columnDefinition = "TEXT")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getHomeDescription() {
        return homeDescription;
    }

    public void setHomeDescription(String homeDescription) {
        this.homeDescription = homeDescription;
    }

    public byte[] getAboutPhoto() {
        return aboutPhoto;
    }

    public void setAboutPhoto(byte[] aboutPhoto) {
        this.aboutPhoto = aboutPhoto;
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    public String getH2Description() {
        return h2Description;
    }

    public void setH2Description(String h2Description) {
        this.h2Description = h2Description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public String generateBase64Image() {
        if (aboutPhoto != null && aboutPhoto.length > 0) {
            return Base64.getEncoder().encodeToString(aboutPhoto);
        }
        return "";
    }
    
}
