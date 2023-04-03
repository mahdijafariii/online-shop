package model.productModel.stationery;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

public class Pencil extends StationeryProduct{
    private String colorOfPen;
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
    public String toString(){
        return super.toString()+" --Type of pencil:"+type+"  --Color:"+colorOfPen;
    }
}
