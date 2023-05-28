package com.example.model.productModel.stationery;

import com.example.model.productModel.CategoryModel;
import com.example.model.productModel.ProductsModel;

public abstract class StationeryProduct extends ProductsModel {
    private String creatorCountry;
    StationeryProduct( String name , double price , int countInCapacity , double averageOfScores  , CategoryModel type , String creatorCountry){
        super(name,price,countInCapacity,averageOfScores,type);
        this.creatorCountry=creatorCountry;
    }

    public void setCreatorCountry(String creatorCountry) {
        this.creatorCountry = creatorCountry;
    }

    public String getCreatorCountry() {
        return creatorCountry;
    }

    @Override
    public String toString(){
        return super.toString()+" -- Country of developing: "+creatorCountry;
    }

}
