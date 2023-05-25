package model.productModel.digitalProduct;
import model.productModel.CategoryModel;

public class Usb extends StorageEquipment{
    private int usbVersion;
    public Usb(String name, double price, int countInCapacity, double averageOfScores, CategoryModel type, double weight, String dimensions, double capacity, int usbVersion){
        super(name,price,countInCapacity,averageOfScores,type ,weight,dimensions,capacity);
        this.usbVersion=usbVersion;
    }

    public int getUsbVersion() {
        return usbVersion;
    }

    public void setUsbVersion(int usbVersion) {
        this.usbVersion = usbVersion;
    }

    @Override
    public String toString(){
        return super.toString()+" --Usb version:"+usbVersion;
    }


}
