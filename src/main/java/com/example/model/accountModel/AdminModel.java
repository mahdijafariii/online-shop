package com.example.model.accountModel;

import com.example.model.productModel.ProductsModel;

import java.util.ArrayList;

public class AdminModel extends AccountModel{
    private static AdminModel admin = AdminModel.getAdmin("admin","admin@gmail.com","09022022022","admin");




    private  ArrayList<ProductsModel> productsOfStore;
    private  ArrayList<OpinionRequestModel> comments;
    private ArrayList<CustomerModel> allCostumers;
    private ArrayList<ChargeRequestModel> chargeRequest;
    private ArrayList<SignUpRequestModel> signUpRequest;
    private ArrayList<DiscountCode> discountCodes;



    private AdminModel(String name,String email ,String phoneNumber , String password){
        super(name,email,phoneNumber,password);
        productsOfStore = new ArrayList<>();
        comments =new ArrayList<>();
        allCostumers=new ArrayList<>();
        chargeRequest=new ArrayList<>();
        signUpRequest=new ArrayList<>();
        discountCodes = new ArrayList<>();
    }

    public static AdminModel getAdmin(String name,String email ,String phoneNumber , String password) {
        if (admin==null){
            admin = new AdminModel(name,email,phoneNumber,password);
        }
        else return getAdmin();
    return admin;}

    public static AdminModel getAdmin() {
        return admin;
    }

    public ArrayList<ProductsModel> getProductsOfStore() {
        return productsOfStore;
    }

    public ArrayList<OpinionRequestModel> getComments() {
        return comments;
    }

    public ArrayList<CustomerModel> getAllCostumers() {
        return allCostumers;
    }

    public ArrayList<ChargeRequestModel> getChargeRequest() {
        return chargeRequest;
    }

    public ArrayList<SignUpRequestModel> getSignUpRequest() {
        return signUpRequest;
    }

    public ArrayList<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }
}
