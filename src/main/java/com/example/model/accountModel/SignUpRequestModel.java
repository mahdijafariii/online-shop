package com.example.model.accountModel;

public class SignUpRequestModel {
    private String userName;
    private String fullName;
    private String passWord;
    private String email;
    private String phoneNumber;
    private int numberOfRequest;
    private static int numberOfRequests=0;
    public SignUpRequestModel(String userName, String fullName, String passWord, String email, String phoneNumber){
        this.fullName=fullName;
        this.passWord=passWord;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.userName=userName;
        numberOfRequests++;
        this.numberOfRequest=numberOfRequests;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public int getNumberOfRequest() {
        return numberOfRequest;
    }
    @Override
    public String toString(){
        return "User name:"+userName+"  --  Full name:"+fullName+"  --  Password:"+passWord+"  --  Phone number:"+phoneNumber+"  --  Number of this request:"+numberOfRequest+"  --  Email"+email;
    }
}
