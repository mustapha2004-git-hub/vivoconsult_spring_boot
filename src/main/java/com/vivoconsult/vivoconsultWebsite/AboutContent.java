package com.vivoconsult.vivoconsultWebsite;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "about_table")
public class AboutContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] aboutPagePhoto;

    private String header2;
    @Column(columnDefinition = "TEXT")
    private String aboutText;




        
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public byte[] getAboutPagePhoto() {
        return aboutPagePhoto;
    }
    public void setAboutPagePhoto(byte[] aboutPagePhoto) {
        this.aboutPagePhoto = aboutPagePhoto;
    }
    public String getHeader2() {
        return header2;
    }
    public void setHeader2(String header2) {
        this.header2 = header2;
    }
    public String getAboutText() {
        return aboutText;
    }
    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }

    public String generateBase64Image() {
        if (aboutPagePhoto != null && aboutPagePhoto.length > 0) {
            return Base64.getEncoder().encodeToString(aboutPagePhoto);
        }
        return "";
    }
}
