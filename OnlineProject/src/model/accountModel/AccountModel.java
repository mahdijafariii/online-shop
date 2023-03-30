package model.accountModel;

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
}

