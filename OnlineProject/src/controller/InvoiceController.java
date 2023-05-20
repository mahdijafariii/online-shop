package controller;

import model.accountModel.CustomerModel;
import model.accountModel.DiscountCode;
import model.accountModel.InvoiceModel;
import model.productModel.ProductsModel;
import model.productModel.stationery.Pen;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceController {
    public double calculateInvoice(InvoiceModel invoice) {
        ArrayList<ProductsModel> test;
        test = invoice.getListOfShoppingItem();
        double price = 0;
        for (int i = 0; i < test.size(); i++) {
            test.get(i).getPrice();
            price = test.get(i).getPrice() + price;
        }
        return price;
    }

    public int deductFromBalance(InvoiceModel invoiceModel, CustomerModel customerModel) {
        double newBalance;
        if (customerModel.getBalance() > invoiceModel.getTotalPrice()) {
            newBalance = customerModel.getBalance() - invoiceModel.getTotalPrice();
            customerModel.setBalance(newBalance);
            return 1;
        } else {
            return -1;
        }
    }

    public double calculateInvoiceWithDiscount(InvoiceModel invoice, DiscountCode discountCode) {
        if (discountCode.getCategory() != null) {
            ArrayList<ProductsModel> test;
            test = invoice.getListOfShoppingItem();
            double price = 0;
            for (int i = 0; i < test.size(); i++) {
                test.get(i).getPrice();
                if (discountCode.getCategory().name().equals(test.get(i).getTypeCategory().name())) {

                } else {
                    price = test.get(i).getPrice() + price;
                }
            }
            return price;

        }
        else if (discountCode.getProduct().getName() != null) {
            ArrayList<ProductsModel> test;
            test = invoice.getListOfShoppingItem();
            double price = 0;
            for (int i = 0; i < test.size(); i++) {
                test.get(i).getPrice();
                if (discountCode.getProduct().getName().equals(test.get(i).getName())) {
                    price = test.get(i).getPrice() * (100 - discountCode.getAmountDiscount()) + price;
                } else {
                    price = test.get(i).getPrice() + price;
                }
            }
            return price;
        }

        else {
            ArrayList<ProductsModel> test;
            test = invoice.getListOfShoppingItem();
            double price = 0;
            for (int i = 0; i < test.size(); i++) {
                test.get(i).getPrice();
                price = test.get(i).getPrice() + price;
            }

            return price*(100-discountCode.getAmountDiscount());
        }
    }
}
