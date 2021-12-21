import javax.swing.*;

public class Main {


    public static void main(String[] args){
        LoginScreen form = new LoginScreen(); //loading the Login Screen

        //Creating and adding Users to List
        UserModel freeUser = new UserModel("free","123", new FreeSubscription());
        UserModel silverUser = new UserModel("silver","123", new SilverSubscription());
        UserModel goldUser = new UserModel("gold","37",new GoldSubscription());
        LoginScreen.userList.add(freeUser);
        LoginScreen.userList.add(silverUser);
        LoginScreen.userList.add(goldUser);


        //Setting the main things on JFrame
        form.setTitle("Video Broadcaster");
        form.setSize(400,300);
        form.setResizable(false);
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
