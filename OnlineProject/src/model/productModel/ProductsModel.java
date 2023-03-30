package model.productModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class ProductsModel {
    private String productID;
    private String name;
    private double price;
    private int countInCapacity;
    private double averageOfScores;
    private ArrayList<String> commentsOfProduct;
    private CategoryModel type;
    private StringBuilder creatId;
    private char test[];
    private static int countFood=0;
    private static int countDigital=0;
    private static int countStationery=0;
    private static int countVehicle=0;

    public ProductsModel(String name ,double price ,int countInCapacity ,double averageOfScores  ,CategoryModel type){
        creatId =new StringBuilder();
        creatId.append(name);
        creatId.append("-");
        test = new char[10];
        test=type.name().toCharArray();
        creatId.append(test[0]);
        creatId.append(test[1]);
        creatId.append(test[2]);
        creatId.append(test[3]);
        creatId.append("-");
        if(test[0]=='F'){
            countFood++;
            creatId.append(countFood);

        }
        else if(test[0]=='V'){
            countVehicle++;
            creatId.append(countVehicle);

        }
        else if(test[0]=='D'){
            countDigital++;
            creatId.append(countDigital);

        }
        else if(test[0]=='S'){
            countStationery++;
            creatId.append(this.countStationery);

        }
        this.productID=creatId.toString();
        this.name=name;
        this.price=price;
        this.countInCapacity=countInCapacity;
        this.averageOfScores=averageOfScores;
        this.type=type;
        commentsOfProduct = new ArrayList<>();
    }

    public String getProductID() {
        return productID;
    }

    public void setCountStationery(int countStationery) {
        this.countStationery = countStationery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setCountInCapacity(int countInCapacity) {
        this.countInCapacity = countInCapacity;
    }
    public void setAverageOfScores(double averageOfScores) {
        this.averageOfScores = averageOfScores;
    }

    public ArrayList<String> getCommentsOfProduct() {
        return commentsOfProduct;
    }

    public double getAverageOfScores() {
        return averageOfScores;
    }

    public double getPrice() {
        return price;
    }

    public int getCountInCapacity() {
        return countInCapacity;
    }

    @Override
    public String toString(){
        return "Name:"+ name +" -- Price:"+price +" -- ID:"+productID+ " -- Category:"+type+" -- Score:"+averageOfScores;
    }
}




