package controller;

import exception.InvalidFormatEmailException;
import exception.InvalidFormatPhoneNumberException;
import model.accountModel.AdminModel;
import model.accountModel.SignUpRequestModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpController {
    private final Pattern email = Pattern.compile("^[_A-Za-z0-9-+]+\\.?[_A-Za-z0-9-+]+@gmail.com$");
    private final Pattern password = Pattern.compile("(\\S){8,}");
    private final Pattern password2 = Pattern.compile("(.*[a-z])(.*[0-9])[a-z0-9#.!@$*&_]");
    private final Pattern phoneNumberPattern = Pattern.compile("(\\S){11}");
    private AdminModel admin = AdminModel.getAdmin();
    public int addUser(String userName,String userEmail,String userPass,String fullName,String phoneNumber) throws InvalidFormatEmailException {
        for (int i = 0; i < admin.getAllCostumers().size(); i++) {
            if (admin.getAllCostumers().get(i).getUserName().equals(userName)) {
                return -1;
            }
            else if((admin.getAllCostumers().get(i).getEmail().equals(userEmail))){
                return -2;
            }
        }
        if(!(checkEmailRegex(userEmail))){
            return -3;
        }
        else if(!(checkPasswordRegex(userPass))){
            return -4;
        }
        else {
            SignUpRequestModel test = new SignUpRequestModel(userName,fullName,userPass,userEmail,phoneNumber);
            admin.getSignUpRequest().add(test);
            return 1;
        }
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

    public boolean checkPhoneNumber(String phoneNumber) throws InvalidFormatPhoneNumberException {
        Matcher phoneMatcher = phoneNumberPattern.matcher(phoneNumber);
        if (!phoneMatcher.find() ) {
            throw new InvalidFormatPhoneNumberException("Format of phone number  is not correct !!");
        } else
            return true;
    }//regex of phoneNumber
    public boolean checkEmailRegex(String email) throws InvalidFormatEmailException {
        Matcher emailMatcher=this.email.matcher(email);
        if(!emailMatcher.find()){
            throw new InvalidFormatEmailException("Format of Email is not correct !! ");
        }
        return true;
    }//regex of email

}

