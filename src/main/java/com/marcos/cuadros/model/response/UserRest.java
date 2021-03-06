package com.marcos.cuadros.model.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserRest {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private Date limitDate;
    private List<PostRest> posts;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
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

    public List<PostRest> getPosts() {
        return posts;
    }

    public void setPosts(List<PostRest> posts) {
        this.posts = posts;
    }
}
