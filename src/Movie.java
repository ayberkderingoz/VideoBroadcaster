import javax.swing.*;
import java.awt.*;

public class Movie extends JPanel {

    public boolean isChildAvailable;
    public SubscriptionModel subscriptionModel;

    public Movie(boolean isChildAvailable,SubscriptionModel subscriptionModel){
        this.isChildAvailable = isChildAvailable;
        this.subscriptionModel = subscriptionModel;
        setBackground(new Color(221,167,123));
        setPreferredSize(new Dimension(200,200));
    }
    public Movie(){
        isChildAvailable = true;
        subscriptionModel = new FreeSubscription();
        setBackground(new Color(221,167,123));
        setPreferredSize(new Dimension(200,200));
    }

}
