package com.example.model.accountModel;

abstract class AccountModel {
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    AccountModel(String name , String email , String phoneNumber , String password){
        this.userName=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

