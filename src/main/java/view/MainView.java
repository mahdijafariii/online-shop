package view;

import exception.InvalidFormatEmailException;

import java.util.Scanner;

public class MainView {


    private Scanner in=new Scanner(System.in);

    public void mainPage() throws InvalidFormatEmailException {
        System.out.println("Select number: \n" +
                "1)admin panel:\n" +
                "2)Sign In:\n" +
                "3)Login:\n" +
                "4)Products:");
        int whatToDo=in.nextInt();
        switch (whatToDo){
            case 1:
                AdminView adminView = new AdminView();
                adminView.adminView();
                break;
            case 2:
                SignUpPanelView signInPanelView = new SignUpPanelView();
                signInPanelView.SignInPanelView();
                break;
            case 3:
                LoginPanelView loginPanelView =new LoginPanelView();
                loginPanelView.loginPanel();
                break;
            case 4:
                ProductView productView = new ProductView();
                productView.productPanel("Gust","Gust");
                break;
        }




    }




}
