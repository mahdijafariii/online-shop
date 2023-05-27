package view;

import controller.SignUpController;
import exception.InvalidFormatEmailException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SignUpPanelView {
    private Scanner in = new Scanner(System.in);
    private final Pattern email = Pattern.compile("^[_A-Za-z0-9-+]+\\.?[_A-Za-z0-9-+]+@gmail.com$");
    private final Pattern password = Pattern.compile("(\\S){8,}");
    private final Pattern password2 = Pattern.compile("(.*[a-z])(.*[0-9])[a-z0-9#.!@$*&_]");
    public void SignInPanelView() throws InvalidFormatEmailException {
        System.out.println("-------------------------Sign In Panel-------------------------");
        while(true) {
            System.out.println("what is you full name ?");
            String fullName = in.nextLine();
            System.out.println("Enter user name that you want to use in store:(user name should not have space between!)");
            String userName = in.nextLine();
            System.out.println("Now please enter a email:");
            String userEmail = in.nextLine();
            System.out.println("Enter password you want to use it in store:");
            String userPass = in.nextLine();
            System.out.println("What is your phone number sir:");
            String phoneNumber = in.nextLine();
            SignUpController test = new SignUpController();
            int check = test.addUser(userName, userEmail, userPass, fullName, phoneNumber);
            if (check == -1) {
                System.out.println("We have this user name in our store please enter another user name:");
            } else if (check == -2) {
                System.out.println("We have this email in our store please enter another user name:");
            } else if (check == -4) {
                System.out.println("This format of password is not accepted (correct format -->start with English letter+ at least one digit + at least one sign(#.!@$*&_)+letters+more than 8 letter!");

            } else if (check == -3) {
                System.out.println("This format of email is not accepted! (correct format --> correct@gmail.com)");


            } else if (check == 1) {
                System.out.println("We send your request for admin if admin accept your request soon you can login with your user name and password!!!");
                break;
            }
        }



    }


}




