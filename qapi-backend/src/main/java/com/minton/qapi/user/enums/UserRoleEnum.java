package com.minton.qapi.user.enums;

public enum UserRoleEnum {

    ADMIN("admin"),
    USER("user");

    private final String role; 

    UserRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
