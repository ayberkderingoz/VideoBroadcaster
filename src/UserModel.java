import java.util.Date;

public class UserModel {
    private String username;
    private String password;
    private Date date;
    private SubscriptionModel subscriptionModel;


    public UserModel(String username,String password,SubscriptionModel subscriptionModel){
        this.username = username;
        this.password = password;
        this.subscriptionModel = subscriptionModel;
        date = new Date(System.currentTimeMillis());
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SubscriptionModel getSubscriptionModel() {
        return subscriptionModel;
    }

    public void setSubscriptionModel(SubscriptionModel subscriptionModel) {
        this.subscriptionModel = subscriptionModel;
    }
}
