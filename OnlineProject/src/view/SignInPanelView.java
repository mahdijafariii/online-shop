package view;

import model.accountModel.AdminModel;
import model.accountModel.SignUpRequestModel;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInPanelView {
    private Scanner in =new Scanner(System.in);
    private final Pattern email = Pattern.compile("^[_A-Za-z0-9-+]+\\.?[_A-Za-z0-9-+]+@gmail.com$");
    private final Pattern password = Pattern.compile("(\\S){8,}");
    private final Pattern password2 = Pattern.compile("(.*[a-z])(.*[0-9])[a-z0-9#.!@$*&_]");
    AdminModel admin = AdminModel.getAdmin();
    public void SignInPanelView(){
        System.out.println("-------------------------Sign In Panel-------------------------");
        System.out.println("what is you full name ?");
        String fullName=in.nextLine();
        boolean checkUserName=true;
        String userName = null;
        while (checkUserName) {
            System.out.println("Enter user name that you want to use in store:(user name should not have space between!)");
            userName = in.nextLine();
            for (int i = 0; i < admin.getAllCostumers().size(); i++) {
                if (admin.getAllCostumers().get(i).getUserName().equals(userName)) {
                    userName = "false";
                    System.out.println("we have this user name in our store please enter another user name:");
                }
            }
            if (!Objects.equals(userName, "false")) {
                checkUserName = false;
            }
        }
        String userEmail=null;
        boolean checkEmail=true;
        while (checkEmail) {
            System.out.println("Now please enter a email:");
            userEmail = in.nextLine();
            if(!(checkEmailRegex(userEmail))){
                System.out.println("This format of email is not accepted! (correct format --> correct@gmail.com)");
                userEmail="false";
            }
            for (int i = 0; i < admin.getAllCostumers().size(); i++) {
                if (admin.getAllCostumers().get(i).getEmail().equals(userEmail)) {
                    userEmail = "false";
                    System.out.println("We have this user name in our store please enter another user name:");
                }
            }
            if (!Objects.equals(userEmail, "false")) {
                checkEmail = false;
            }
        }
        String userPass =null;
        while (true) {
            System.out.println("Enter pass word you want to use it in store:");
            userPass = in.nextLine();
            if(!(checkPasswordRegex(userPass))){
                System.out.println("This format is not accepted (correct format --> at least one digit + at least one sign(#.!@$*&_)+letters+more than 8 letter!");
            }
            else
                break;
    }


        System.out.println("What is your phone number sir:");
        String phoneNumber=in.nextLine();
        SignUpRequestModel test = new SignUpRequestModel(userName,fullName,userPass,userEmail,phoneNumber);
        admin.getSignUpRequest().add(test);
        System.out.println("We send your request for admin if admin accept your request soon you can login with your user name and password!!!");


    }
    public boolean checkPasswordRegex(String passwordCheck)
    {

        Matcher passMatcher = password.matcher(passwordCheck);
        Matcher passMatcher2 = password2.matcher(passwordCheck);
        if (passMatcher.find() & passMatcher2.find()) {
            return true;
        } else
            return false;
    }//regex of password
    public boolean checkEmailRegex(String email)
    {
        Matcher emailMatcher=this.email.matcher(email);
        return emailMatcher.find();
    }//regex of email



}
