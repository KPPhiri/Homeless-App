package com.example.philipphiri.homelessapp;

/**
 * Created by philipphiri on 2/20/18.
 */

public class User {
    private String userType;
    private String permissionLevel;

    public User(String userType, String permissionLevel) {
        this.userType = userType;
        this.permissionLevel = permissionLevel;

    }

    public String getUserType(){
        return userType;
    }



    public String getPermissionLevel(){
        return permissionLevel;
    }

    public void setUserType(){
        this.userType = userType;
    }

    public void setPermissionLevel(){
        this.permissionLevel = permissionLevel;
    }

}