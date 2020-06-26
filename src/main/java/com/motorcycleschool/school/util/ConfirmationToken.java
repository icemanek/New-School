package com.motorcycleschool.school.util;

import com.motorcycleschool.school.model.Instructor;
import com.motorcycleschool.school.model.User;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
public class ConfirmationToken {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private long tokenid;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

//    @OneToOne(targetEntity = Instructor.class)
//    @JoinColumn(nullable = false, name = "instructor_id")
//    private Instructor instructor;

    @Column(nullable = false)
    private Date expiryDate;

    public ConfirmationToken() {
    }

    public void setExpiryDate(int hours) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR, hours);

        this.expiryDate = now.getTime();
    }

    public Date getExpiryDate() {
        return expiryDate;
    }


    public boolean isExpired() {

        return new Date().after(this.expiryDate);
    }

    public ConfirmationToken(User user) {
        this.user = user;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();

    }

//    public ConfirmationToken(Instructor instructor) {
//        this.instructor = instructor;
//        createdDate = new Date();
//        confirmationToken = UUID.randomUUID().toString();
//
//    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTokenid() {
        return tokenid;
    }

    public void setTokenid(long tokenid) {
        this.tokenid = tokenid;
    }

//    public Instructor getInstructor() {
//        return instructor;
//    }
//
//    public void setInstructor(Instructor instructor) {
//        this.instructor = instructor;
//    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
