package com.example.model.accountModel;

import com.example.model.productModel.ProductsModel;

public class ScoreModel {
    private CustomerModel buyer ;
    private double score;
    private ProductsModel products;
    public ScoreModel(CustomerModel buyer,double score,ProductsModel products){
        this.buyer=buyer;
        this.score=score;
        this.products=products;
    }

    public CustomerModel getBuyer() {
        return buyer;
    }

    public double getScore() {
        return score;
    }

    public ProductsModel getProducts() {
        return products;
    }

    public void setBuyer(CustomerModel buyer) {
        this.buyer = buyer;
    }

    public void setProducts(ProductsModel products) {
        this.products = products;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

