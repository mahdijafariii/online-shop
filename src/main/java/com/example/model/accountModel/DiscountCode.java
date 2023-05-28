package com.example.model.accountModel;

import com.example.model.productModel.CategoryModel;

import java.util.Date;
import java.util.Random;

public class DiscountCode {
    double amountDiscount;
    Date time;
    int discountCodeCapacity;
    CategoryModel category;
    String productName;
    String code;
    Random random = new Random();

     public DiscountCode(double amountDiscount ,Date time , int discountCodeCapacity){
        this.discountCodeCapacity = discountCodeCapacity;
        this.time=time;
        this.amountDiscount=amountDiscount;
        StringBuilder test = new StringBuilder();
        test.append("Digi");
        test.append("-");
        test.append(random.nextInt(20));
        test.append("-");
        test.append("0");
        test.append(time.getDate());
        test.append("-");
        test.append(amountDiscount);
        this.code = test.toString();
    }
    public DiscountCode(double amountDiscount , Date time , int discountCodeCapacity , String category){
        this.discountCodeCapacity = discountCodeCapacity;
        this.time=time;
        this.amountDiscount=amountDiscount;
        category.toUpperCase();
        this.category=CategoryModel.valueOf(category);
        StringBuilder test = new StringBuilder();
        test.append("Digi");
        test.append("-");
        test.append(random.nextInt(1000));
        test.append("-");
        test.append(category);
        test.append("-");
        test.append(amountDiscount);
        this.code = test.toString();
    }
    public DiscountCode(double amountDiscount , Date time ,   String product,int discountCodeCapacity){
        this.discountCodeCapacity = discountCodeCapacity;
        this.time=time;
        this.amountDiscount=amountDiscount;
        this.productName=product;
        StringBuilder test = new StringBuilder();
        test.append("Digi");
        test.append("-");
        test.append(random.nextInt(1000));
        test.append("-");
        test.append(product);
        test.append("-");
        test.append(amountDiscount);
        this.code = test.toString();
    }



    public String getCategory() {
         if(category==null){
             return "null";
         }
        return category.name();
    }

    public double getAmountDiscount() {
        return amountDiscount;
    }

    public int getDiscountCodeCapacity() {
        return discountCodeCapacity;
    }


    public String getProductName() {
        return productName;
    }

    public String getCode() {
        return code;
    }

    public Date getTime() {
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

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String toString(){
         return "code:  " + getCode() + "  --  amount:  " + amountDiscount + "  --  capacity:"+getDiscountCodeCapacity()+"  --  Special discount :  "+ "category->  " + getCategory() + "--  name->"+getProductName();
    }
}
