package com.vivoconsult.vivoconsultWebsite;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "userMessages")

public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String mail;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Basic(optional = false)
    @CreationTimestamp
    @Column(name = "message_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date messageDate ;




    private boolean isRead;

    private boolean isStared;




    public void setMessageDate(Date messagesDate) {
        Date creatDate = this.messageDate;
        if (this.messageDate == messagesDate) {
            this.messageDate = messagesDate;
        }else{
            this.messageDate=creatDate;
        }
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageDate() {
        return messageDate;
    }


    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean isStared() {
        return isStared;
    }

    public void setStared(boolean isStared) {
        this.isStared = isStared;
    }

    @PreUpdate
    public void setMessageDate() {
        this.messageDate = new Date();
    }

    

}
