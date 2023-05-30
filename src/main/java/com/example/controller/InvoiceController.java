package com.example.controller;

import com.example.model.accountModel.CustomerModel;
import com.example.model.accountModel.InvoiceModel;
import com.example.model.productModel.ProductsModel;

import java.util.ArrayList;

public class InvoiceController {
    public double calculateInvoice(InvoiceModel invoice,double discount) {
        ArrayList<ProductsModel> test;
        test = invoice.getListOfShoppingItem();
        double price = 0;
        for (int i = 0; i < test.size(); i++) {
            test.get(i).getPrice();
            price = test.get(i).getPrice() + price;
        }
        return price-discount;
    }

//    public int deductFromBalance(InvoiceModel invoiceModel, CustomerModel customerModel) {
//        double newBalance;
//        if (customerModel.getBalance() > invoiceModel.getTotalPrice()) {
//            newBalance = customerModel.getBalance() - (invoiceModel.getTotalPrice());
//            customerModel.setBalance(newBalance);
//            return 1;
//        } else {
//            return -1;
//        }
//    }
    public int checkBalanceWithDiscount(InvoiceModel invoiceModel, CustomerModel customerModel,double discount){
        if (customerModel.getBalance() > (invoiceModel.getTotalPrice()-discount)){
            return 1;
        }
        else{
            return -1;
        }
    }

//    public double calculateInvoiceWithDiscountCategory(InvoiceModel invoice, DiscountCode discountCode) {
//        if (discountCode.getCategory() != null) {
//            ArrayList<ProductsModel> test;
//            test = invoice.getListOfShoppingItem();
//            double price = 0;
//            for (int i = 0; i < test.size(); i++) {
//                if (discountCode.getCategory().name().equals(test.get(i).getTypeCategory().name())) {
//                    price = test.get(i).getPrice()*(100-discountCode.getAmountDiscount())+ price;
//                }
//            }
//            return price;
//        }
//        return 0;
//
//    }
//    public double calculateInvoiceWithDiscountName(InvoiceModel invoice, DiscountCode discountCode){
//        if (discountCode.getProductName() != null) {
//            ArrayList<ProductsModel> test;
//            test = invoice.getListOfShoppingItem();
//            double price = 0;
//            for (int i = 0; i < test.size(); i++) {
//                test.get(i).getPrice();
//                if (discountCode.getProductName().equals(test.get(i).getName())) {
//                    price = test.get(i).getPrice()*(100-discountCode.getAmountDiscount())+ price;
//                }
//            }
//            return price;
//        }
//        return 0;
//    }
//    public double calculateAllDiscounts(ArrayList<Double> discounts ,InvoiceModel invoice){
//        ArrayList<ProductsModel> test;
//        test = invoice.getListOfShoppingItem();
//        double price = 0;
//        for (int i = 0; i < test.size(); i++) {
//            test.get(i).getPrice();
//            price = test.get(i).getPrice() + price;
//        }
//        for(int i = 0 ; i <discounts.size() ;i ++){
//            price = price- discounts.get(i);
//        }
//        return price;
//    }
}
