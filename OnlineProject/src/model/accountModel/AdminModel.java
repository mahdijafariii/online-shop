package model.accountModel;

import model.productModel.ProductsModel;

import java.util.ArrayList;

public class AdminModel extends AccountModel{

    private ArrayList<ProductsModel> productsOfStore;
    private ArrayList<String> comments;



    private static AdminModel admin ;
    public AdminModel(String name,String email ,String phoneNumber , String password){
        super(name,email,phoneNumber,password);
        productsOfStore = new ArrayList<>();
        comments =new ArrayList<>();
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

    public ArrayList<String> getComments() {
        return comments;
    }
}
