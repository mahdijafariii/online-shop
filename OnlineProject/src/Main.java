import model.productModel.CategoryModel;
import model.productModel.ProductsModel;
import model.productModel.stationery.Pen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Pen pen = new Pen("12", 12.5, 125, 5, CategoryModel.STATIONERY, "iran", "blue");
        Pen akbar = new Pen("12", 12.5, 125, 6, CategoryModel.STATIONERY, "iran", "blue");
        System.out.println(pen.toString());
        System.out.println(akbar.toString());
        Pattern email = Pattern.compile("(\\S){8,}");
        Pattern email2 = Pattern.compile("(.*[a-z])(.*[0-9])[a-z0-9#.!@$*&_]");
        Matcher match1;
        Matcher match2;
        String name;
        System.out.println();
        boolean ahmad;




    }

    public boolean ali(String name) {
        Pattern password = Pattern.compile("(\\S){8,}");
        Pattern password2 = Pattern.compile("(.*[a-z])(.*[0-9])[a-z0-9#.!@$*&_]");
        Matcher match1 = password.matcher(name);
        Matcher match2 = password2.matcher(name);
        if (match1.find() & match2.find()) {
            return true;
        } else
            return false;
    }


}