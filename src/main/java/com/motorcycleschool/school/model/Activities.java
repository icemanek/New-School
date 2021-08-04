package com.motorcycleschool.school.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long activitiesId;

    @NotEmpty
    @Column(unique = true)
    private String activitiesTitle;

    @Lob
    @Column(name = "activities_image", nullable = false, columnDefinition = "mediumblob")
    private byte[] activitiesImage;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    private Date activitiesDate;

//    @ManyToMany(mappedBy = "activitiesList")
//    private Set<Instructor> instructors = new HashSet<>();
//
//
//    @ManyToMany(mappedBy = "activitiesListFromUser")
//    private Set<User> users = new HashSet<>();

    public Date getActivitiesDate() {
        return activitiesDate;
    }

    public void setActivitiesDate(Date activitiesDate) {
        this.activitiesDate = activitiesDate;
    }

    public Long getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(Long activitiesId) {
        this.activitiesId = activitiesId;
    }

    public String getActivitiesTitle() {
        return activitiesTitle;
    }

    public void setActivitiesTitle(String activitiesTitle) {
        this.activitiesTitle = activitiesTitle;
    }

    public byte[] getActivitiesImage() {
        return activitiesImage;
    }

    public void setActivitiesImage(byte[] activitiesImage) {
        this.activitiesImage = activitiesImage;
    }

}
