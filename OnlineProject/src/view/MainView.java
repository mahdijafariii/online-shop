package view;

import java.util.Scanner;

public class MainView {


    private Scanner in=new Scanner(System.in);

    public void mainPage(){
        System.out.println("Select number: \n" +
                "1)admin panel:\n" +
                "2)Sign In:\n");
        int whatToDo=in.nextInt();
        switch (whatToDo){
            case 1:
                AdminView adminView = new AdminView();
                adminView.adminView();
                break;
            case 2:
                SignInPanelView signInPanelView = new SignInPanelView();
                signInPanelView.SignInPanelView();
                break;
        }




    }




}
