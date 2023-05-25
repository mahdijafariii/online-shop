package model.productModel.stationery;
import model.accountModel.AdminModel;
import model.productModel.CategoryModel;
import model.productModel.discount;

public class Pencil extends StationeryProduct implements discount {
    private String colorOfPen;
    private double amountDiscount ;
     public enum typeOfPencil {
        HB,B,F,H,H2;
    }
    typeOfPencil type;
    public Pencil(String name, double price, int countInCapacity, double averageOfScores, CategoryModel type, String creatorCountry, String colorOfPen, typeOfPencil typeOfPenceil){
        super(name,price,countInCapacity,averageOfScores,type,creatorCountry);
        this.type=typeOfPenceil;
        this.colorOfPen=colorOfPen;
    }

    public void setType(typeOfPencil type) {
        this.type = type;
    }


    public String getType() {
        return type.name();
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
        return super.toString()+" --Type of pencil:"+type+"  --Color:"+colorOfPen;
    }
}
