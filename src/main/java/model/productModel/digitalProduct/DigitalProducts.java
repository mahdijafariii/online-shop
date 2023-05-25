package model.productModel.digitalProduct;

import model.accountModel.AdminModel;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;
import model.productModel.discount;

public abstract class DigitalProducts extends ProductsModel implements discount {
    private double weight;
    private String dimensions;
    private double amountDiscount ;

    DigitalProducts(String name ,double price ,int countInCapacity ,double averageOfScores  ,CategoryModel type,double weight,String dimensions){
        super(name,price,countInCapacity,averageOfScores,type);
        this.weight=weight;
        this.dimensions=dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }
    @Override
    public void setDiscount(String name, double amount) {
        for(int i = 0; i< AdminModel.getAdmin().getProductsOfStore().size() ; i++ ){
            if(AdminModel.getAdmin().getProductsOfStore().get(i).getProductID().equals(name)){
                amountDiscount =amount;
                AdminModel.getAdmin().getProductsOfStore().get(i).setPrice(AdminModel.getAdmin().getProductsOfStore().get(i).getPrice()*((100-amount)/100));
                break;
            }
        }
    }

    @Override
    public void removeDiscount(String name) {
        for(int i = 0 ; i< AdminModel.getAdmin().getProductsOfStore().size() ; i++ ){
            if(AdminModel.getAdmin().getProductsOfStore().get(i).getProductID().equals(name)){
                AdminModel.getAdmin().getProductsOfStore().get(i).setPrice((AdminModel.getAdmin().getProductsOfStore().get(i).getPrice()*(100))/(100-amountDiscount));
                break;
            }
        }
    }

    @Override
    public String toString(){
        return super.toString()+" --Weight:"+weight+" --Dimensions:"+dimensions;
    }

}
