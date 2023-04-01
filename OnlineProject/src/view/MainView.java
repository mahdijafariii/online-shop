package view;

import java.util.Scanner;

public class MainView {


    private Scanner in=new Scanner(System.in);

    public void mainPage(){
        System.out.println("Select number: \n" +
                "1)admin panel:");
        int whatToDo=in.nextInt();
        switch (whatToDo){
            case 1:
                AdminView adminView = new AdminView();
                adminView.adminView();
                break;
            case 2:
        }




    }




}
