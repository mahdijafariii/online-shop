package com.example.controller;

import com.example.model.accountModel.AdminModel;
import com.example.model.productModel.ProductsModel;

import java.util.ArrayList;

public class ProductController {
    private AdminModel admin=AdminModel.getAdmin();
    public ArrayList<String> showProduct(){

        ArrayList<String> showProducts=new ArrayList<>();
        StringBuilder test = new StringBuilder();
        int count=0;
        admin.getProductsOfStore().sort(ProductsModel::compareTo);
        for(int i=0 ; i<admin.getProductsOfStore().size() ;i++){
                test.append((i + 1));
                test.append(")");
                test.append(admin.getProductsOfStore().get(i).toString());
                test.append("  --  capacity in store:"+admin.getProductsOfStore().get(i).getCountInCapacity());
                test.append(" \n");
                count++;
                if(count==admin.getProductsOfStore().size()-1){
                    showProducts.add(test.toString());
                }
                if(count%9==0&count>1){
                    showProducts.add(test.toString());
                    test =new StringBuilder();
                }
        }

    return showProducts;}
    public String showProductInfo(int numberInList){
        StringBuilder test = new StringBuilder();
        test.append("---------------------------"+admin.getProductsOfStore().get(numberInList-1).toString()+"---------------------------\n\n");
        test.append("---------------------------------------------------------------------------------------comment-----------------------------------------------------------------------------------------------------\n");
        for(int j=0 ;j<admin.getProductsOfStore().get(numberInList-1).getCommentsOfProduct().size();j++ ){
            test.append((j+1)+")"+admin.getProductsOfStore().get(numberInList-1).getCommentsOfProduct().get(j).getOpinion()+"----------------\n");
        }

    return test.toString();}
    public int previousPage(int count ){
        if(count>1){
            count=count-1;
            return count;
        }
        else{
            count=0;
            return count;
        }
    }
    public int nextPage(int count){
        if((admin.getProductsOfStore().size()/9>count)&&(count+1!=admin.getProductsOfStore().size())){
            count=count+1;
            return count;
        }
    return count;}
}
