package model.accountModel;

public class OpinionModel {
    private CustomerModel user ;
    private String productId;
    private String opinion;
    private int opinionStatus;// this is that the opinion is accepted or rejected or admin do not answer yet! //0:waiting 1:accepted -1:rejected
    private boolean IsUserBuyProduct;
    public OpinionModel(CustomerModel user, String productId, String opinion){
        this.user=user;
        this.productId=productId;
        this.opinion=opinion;
        this.opinionStatus=0;
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
}
