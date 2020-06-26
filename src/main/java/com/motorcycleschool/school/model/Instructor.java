package com.motorcycleschool.school.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.mindrot.jbcrypt.BCrypt;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INSTRUCTORS")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instructorId;

    @NotEmpty
    @Length(min = 2)
    private String instructorUsername;

    @NotEmpty
    @Length(min = 2)
    private String instructorFirstname;

    @NotEmpty
    @Length(min = 2)
    private String instructorLastname;

    @NotEmpty
    @Length(min = 8)
    private String instructorPassword;

    @NotEmpty
    @Email
    private String instructorEmail;

    @CreationTimestamp
    private LocalDate createdInstructor;

    @Transient
    private String fullNameInstructor;

    private String role = "instructor";

    private int enabled = 1;

//    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinTable(name = "instructor_activities", joinColumns = @JoinColumn(name = "instructor_id"), inverseJoinColumns = @JoinColumn(name = "activities_id"))
//    private Set<Activities> activitiesList = new HashSet<>();
//
//    public void addActivities(Activities activities){
//        this.activitiesList.add(activities);
//    }
//
//    public void deleteActivities(Activities activities){
//        this.activitiesList.remove(activities);
//    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorUsername() {
        return instructorUsername;
    }

    public void setInstructorUsername(String instructorUsername) {
        this.instructorUsername = instructorUsername;
    }

    public String getInstructorFirstname() {
        return instructorFirstname;
    }

    public void setInstructorFirstname(String instructorFirstname) {
        this.instructorFirstname = instructorFirstname;
    }

    public String getInstructorLastname() {
        return instructorLastname;
    }

    public void setInstructorLastname(String instructorLastname) {
        this.instructorLastname = instructorLastname;
    }

    public String getInstructorPassword() {
        return instructorPassword;
    }

    public void setInstructorPassword(String instructorPassword) {
        this.instructorPassword = BCrypt.hashpw(instructorPassword, BCrypt.gensalt());
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public LocalDate getCreatedInstructor() {
        return createdInstructor;
    }

    public void setCreatedInstructor(LocalDate createdInstructor) {
        this.createdInstructor = createdInstructor;
    }

    public String getFullNameInstructor() {
        return fullNameInstructor;
    }

    public void setFullNameInstructor(String fullNameInstructor) {
        this.fullNameInstructor = fullNameInstructor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
