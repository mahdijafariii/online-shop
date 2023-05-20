package model.accountModel;

import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

import java.sql.Time;
import java.util.Random;

public class DiscountCode {
    double amountDiscount;
    Time time;
    int discountCodeCapacity;
    CategoryModel category;
    ProductsModel product;
    String code;
    Random random = new Random();

    DiscountCode(double amountDiscount ,Time time , int discountCodeCapacity){
        this.discountCodeCapacity = discountCodeCapacity;
        this.time=time;
        this.amountDiscount=amountDiscount;
        StringBuilder test = new StringBuilder();
        test.append("Digi");
        test.append("-");
        test.append(random.nextInt(20));
        test.append("-");
        test.append(time);
        test.append("-");
        test.append(amountDiscount);
        this.code = test.toString();
    }
    DiscountCode(double amountDiscount , Time time , int discountCodeCapacity , CategoryModel category){
        this.discountCodeCapacity = discountCodeCapacity;
        this.time=time;
        this.amountDiscount=amountDiscount;
        StringBuilder test = new StringBuilder();
        test.append("Digi");
        test.append("-");
        test.append(random.nextInt(1000));
        test.append("-");
        test.append(category.name());
        test.append("-");
        test.append(amountDiscount);
        this.code = test.toString();
    }
    DiscountCode(double amountDiscount , Time time , int discountCodeCapacity , ProductsModel product){
        this.discountCodeCapacity = discountCodeCapacity;
        this.time=time;
        this.amountDiscount=amountDiscount;
        StringBuilder test = new StringBuilder();
        test.append("Digi");
        test.append("-");
        test.append(random.nextInt(1000));
        test.append("-");
        test.append(product.getName());
        test.append("-");
        test.append(amountDiscount);
        this.code = test.toString();
    }

    public CategoryModel getCategory() {
        return category;
    }

    public double getAmountDiscount() {
        return amountDiscount;
    }

    public int getDiscountCodeCapacity() {
        return discountCodeCapacity;
    }

    public ProductsModel getProduct() {
        return product;
    }

    public String getCode() {
        return code;
    }

    public Time getTime() {
        return time;
    }

    public void setAmountDiscount(double amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public void setDiscountCodeCapacity(int discountCodeCapacity) {
        this.discountCodeCapacity = discountCodeCapacity;
    }

    public void setProduct(ProductsModel product) {
        this.product = product;
    }

}
