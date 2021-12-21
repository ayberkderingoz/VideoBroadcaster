import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionModel {
    public String qualitySetting;
    public ArrayList<String> genreList = new ArrayList<>();
    public String price;

    public String getPrice(){return price;}

    public void setPrice(String price){
        this.price = price;
    }
    public String getQualitySetting() {
        return qualitySetting;
    }

    public void setQualitySetting(String quality) {
        qualitySetting = quality;
    }
}
class FreeSubscription extends SubscriptionModel{

    public FreeSubscription(){
        this.setQualitySetting("480p");
        this.setPrice("Free");
        genreList.add("Adventure");
        genreList.add("Science Fiction");
    }
    public String toString() {
        return "Free Subscription";
    }
}
class SilverSubscription extends SubscriptionModel{
    public SilverSubscription(){
        this.setQualitySetting("720p");
        this.setPrice("15₺");
        genreList.add("Adventure");
        genreList.add("Science Fiction");
        genreList.add("Documentary");
    }
    public String toString(){
        return "Silver Subscription";
    }
}
class GoldSubscription extends SubscriptionModel{
    public GoldSubscription(){
        this.setQualitySetting("1080p");
        this.setPrice("30₺");
        genreList.add("Adventure");
        genreList.add("Science Fiction");
        genreList.add("Documentary");
        genreList.add("Horror");
    }
    public String toString(){
        return "Gold Subscription";
    }
}
