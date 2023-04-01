package model.accountModel;

public class OpinionRequestModel {
    private CustomerModel user ;
    private String productId;
    private static int opinionNumber=0;
    private int opinionNumb;//this help admin to accept or reject comment with see a list of comment one time!
    private String opinion;
    private int opinionStatus;// this is that the opinion is accepted or rejected or admin do not answer yet! //0:waiting 1:accepted -1:rejected
    private boolean IsUserBuyProduct;
    public OpinionRequestModel(CustomerModel user, String productId, String opinion){
        this.user=user;
        this.productId=productId;
        this.opinion=opinion;
        this.opinionStatus=0;
        opinionNumber++;
        this.opinionNumb=opinionNumber;
    }

    public CustomerModel getUser() {
        return user;
    }

    public int getOpinionStatus() {
        return opinionStatus;
    }

    public String getOpinion() {
        return opinion;
    }

    public String getProductId() {
        return productId;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public void setOpinionStatus(int opinionStatus) {
        this.opinionStatus = opinionStatus;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setUser(CustomerModel user) {
        this.user = user;
    }

    public void setUserBuyProduct(boolean userBuyProduct) {
        IsUserBuyProduct = userBuyProduct;
    }

    public int getOpinionNumb() {
        return opinionNumb;
    }
    public String toString(){
        return "Product ID:" + getProductId() +"  --  opinion number:"+ getOpinionNumb()+"  -- text:"+ getOpinion();
    }
}
