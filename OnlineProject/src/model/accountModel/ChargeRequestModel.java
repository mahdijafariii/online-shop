package model.accountModel;

public class ChargeRequestModel {
    private CustomerModel customer;
    private String amount;
    private String cvv2;
    private String cardNumber;
    private String cardPass;
    public ChargeRequestModel(CustomerModel customer,String amount , String cvv2 ,String cardNumber , String cardPass){
        this.customer=customer;
        this.amount=amount;
        this.cardNumber=cardNumber;
        this.cvv2=cvv2;
        this.cardPass=cardPass;

    }
    public String toString(){
        return "Name:"+customer.getUserName()+"  --  card number:"+cardNumber+"  --  cvv2:"+cvv2+"  --  card pass:"+cardPass+"  --  charge amount:"+amount;
    }

}
