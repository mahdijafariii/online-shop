package controller;

import model.accountModel.AdminModel;

import java.util.ArrayList;

public class ProductController {
    AdminModel admin=AdminModel.getAdmin();
    public ArrayList<String> showProduct(){
        ArrayList<String> showProducts=new ArrayList<>();
        StringBuilder test = new StringBuilder();
        for(int i=0 ; i<admin.getProductsOfStore().size() ;i++){
            test.append((i+1)+")"+admin.getProductsOfStore().get(i).toString()+" \n" );
            if(i%9==0){
                showProducts.add(test.toString());
                test =new StringBuilder();
            }
        }

    return showProducts;}
    public String showProductInfo(int numberInList){
        StringBuilder test = new StringBuilder();
        test.append("---------------------------"+admin.getProductsOfStore().get(numberInList-1).toString()+"---------------------------");
        test.append("--------------------------------------------------------comment-----------------------------------------------------");
        for(int j=0 ;j<admin.getProductsOfStore().get(numberInList-1).getCommentsOfProduct().size();j++ ){
            test.append((j+1)+")"+admin.getProductsOfStore().get(numberInList-1).getCommentsOfProduct().get(j).getText()+"----------------\n");
        }

    return test.toString();}
}
