package com.motorcycleschool.school.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.mindrot.jbcrypt.BCrypt;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Pole nie może być puste!")
    @Length(min = 5, message = "Za mało znaków")
    private String username;

    @NotEmpty(message = "Pole nie może być puste!")
    @Length(min = 3, message = "Za mało znaków")
    private String firstName;

    @NotEmpty(message = "Pole nie może być puste!")
    @Length(min = 2, message = "Za mało znaków")
    private String lastName;

    @NotEmpty(message = "Pole nie może być puste!")
    @Length(min = 8, message = "Za malo znaków")
    private String password;

    @Email
    @NotEmpty(message = "Pole nie może być puste!")
    private String email;

    @CreationTimestamp
    private Date created;

    private String gender;

    private String licence;

    @Column
    @Type(type = "date")
    private Date birth;

    private String role = "user";

    private boolean enabled;

    @Column(name = "reset_token")
    private String resetToken;

//    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinTable(name = "user_activities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "activities_id"))
//    private Set<Activities> activitiesListFromUser = new HashSet<>();

//    public void addActivities(Activities activities){
//        this.activitiesListFromUser.add(activities);
//    }
//
//    public void deleteActivities(Activities activities){
//        this.activitiesListFromUser.remove(activities);
//    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
//       this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", gender='" + gender + '\'' +
                ", licence='" + licence + '\'' +
                ", birth=" + birth +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                ", resetToken='" + resetToken + '\'' +
                '}';
    }
}

