package com.booktrading.demo.Dto;

import lombok.Data;

public class QueryDto {

    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernmae) {
        this.username = usernmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
