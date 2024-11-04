package com.minton.qapi.user.request;

import com.minton.qapi.user.model.User;

public class UserRequest {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRequest() {
    }

    public UserRequest(User user) {
        this.user = user;
    }
}
