package model.accountModel;

public class ChargeRequestModel {
    private int numberRequest;
    private CustomerModel customer;
    private String amount;
    private String cvv2;
    private String cardNumber;
    private String cardPass;
    private static int numberRequests;
    public ChargeRequestModel(CustomerModel customer,String amount , String cvv2 ,String cardNumber , String cardPass){
        this.customer=customer;
        this.amount=amount;
        this.cardNumber=cardNumber;
        this.cvv2=cvv2;
        this.cardPass=cardPass;
        numberRequests++;
        this.numberRequest=numberRequests;

    }
    public String toString(){
        return "Name:"+customer.getUserName()+"  --  card number:"+cardNumber+"  --  cvv2:"+cvv2+"  --  card pass:"+cardPass+"  --  charge amount:"+amount+"  --  Number request:"+numberRequest;
    }

    public int getNumberRequest() {
        return numberRequest;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public String getAmount() {
        return amount;
    }
}
