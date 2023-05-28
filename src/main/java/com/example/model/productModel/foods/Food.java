package com.example.model.productModel.foods;

import com.example.model.productModel.CategoryModel;
import com.example.model.productModel.ProductsModel;

public class Food extends ProductsModel{
    private int dateOfProduction;
    private int dateOfExpiration;
    public Food(String name, double price, int countInCapacity, double averageOfScores, CategoryModel type, int dateOfProduction, int dateOfExpiration){
        super(name,price,countInCapacity,averageOfScores,type);
        this.dateOfExpiration=dateOfExpiration;
        this.dateOfProduction=dateOfProduction;
    }

    public void setDateOfExpiration(int dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public void setDateOfProduction(int dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public int getDateOfProduction() {
        return dateOfProduction;
    }

    public int getDateOfExpiration() {
        return dateOfExpiration;
    }

    @Override
    public String toString(){
        return super.toString()+"\nDate of production and expiration: "+dateOfProduction+" ~~ "+dateOfExpiration;
    }


}
