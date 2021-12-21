import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditUserScreen extends JFrame {

    private JLabel usernameLabel,passwordLabel,subscriptionLabel;
    private JTextField usernameText,passwordText;
    private JButton confirmButton,backButton;
    private JComboBox dropDownList;
    private UserModel currentUser;

    public EditUserScreen(UserModel user){


        //Generating the objects needed
        usernameLabel = new JLabel("username :");
        passwordLabel = new JLabel("password :");
        subscriptionLabel = new JLabel("Current Subscription :");
        usernameText = new JTextField();
        usernameText.setText(user.getUsername());
        passwordText = new JTextField();
        passwordText.setText(user.getPassword());
        dropDownList = new JComboBox();
        backButton = new JButton("Back");
        confirmButton = new JButton("Edit");


        fillDropDownList(user,dropDownList); //Filling the drop down list with subscriptions



        //Filling the container
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,2)); //Creating a 4,2 Grid
        c.add(usernameLabel);
        c.add(usernameText);

        c.add(passwordLabel);
        c.add(passwordText);

        c.add(subscriptionLabel);
        c.add(dropDownList);

        c.add(confirmButton);
        c.add(backButton);

        MyEventHandler eventHandler = new MyEventHandler();
        //adding Listeners
        confirmButton.addActionListener(eventHandler);
        backButton.addActionListener(eventHandler);
        currentUser = user;
    }

    private void fillDropDownList(UserModel user,JComboBox dropDownList){
        //filling the drop down list and setting the current users subscription to the top
        List<String> list = new ArrayList<>();
        list.add(new FreeSubscription().toString());
        list.add(new SilverSubscription().toString());
        list.add(new GoldSubscription().toString());
        dropDownList.addItem(user.getSubscriptionModel().toString());

        for (String sub: list) {
            if(!dropDownList.getItemAt(0).equals(sub))
                dropDownList.addItem(sub);
        }


    }
    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource() == confirmButton){ //confirm button event,setting the user data with new data
                int index = LoginScreen.userList.indexOf(currentUser);
                LoginScreen.userList.get(index).setUsername(usernameText.getText());
                LoginScreen.userList.get(index).setPassword(passwordText.getText());
                LoginScreen.userList.get(index).setSubscriptionModel(getDropdownList());
                JOptionPane.showMessageDialog(null,"Changed successfully");
            }
            if(actionEvent.getSource() == backButton){
                loadMainScreen(currentUser); //loading main screen
            }
        }
        private void loadMainScreen(UserModel user){
            MainScreen mainScreen = new MainScreen(user);
            setVisible(false);
            mainScreen.setTitle("Video Broadcaster");
            mainScreen.setSize(800,600);
            mainScreen.setResizable(false);
            mainScreen.setVisible(true);
            mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public SubscriptionModel getDropdownList(){ //returns the subscription that chosen

            if(dropDownList.getSelectedItem().toString().equals("Free Subscription"))
                return new FreeSubscription();
            else if(dropDownList.getSelectedItem().toString().equals("Silver Subscription"))
                return new SilverSubscription();
            else
                return new GoldSubscription();
        }
    }

}
