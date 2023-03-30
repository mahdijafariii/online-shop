package model.productModel;

import java.util.ArrayList;

public abstract class ProductsModel {
    private String productID;
    private String name;
    private double price;
    private boolean inventoryStatus;
    private double averageOfScores;
    private ArrayList<String> commentsOfProduct;
    private CategoryModel type;
    public ProductsModel(String productID,String name ,double price ,boolean inventoryStatus ,double averageOfScores  ,CategoryModel type){
        this.productID=productID;
        this.name=name;
        this.price=price;
        this.inventoryStatus=inventoryStatus;
        this.averageOfScores=averageOfScores;
        this.type=type;
        commentsOfProduct = new ArrayList<>();
    }

}




