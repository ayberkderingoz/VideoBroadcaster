import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginScreen extends JFrame {
    private JTextField usernameLogin, usernameRegister;
    private JPasswordField passwordLogin,passwordRegister;
    private JLabel usernameLabel,passwordLabel,registerUsername,registerPassword;
    private JButton loginButton,registerButton;
    private JPanel panel1,panel2;
    private JComboBox dropDownList;
    public static ArrayList<UserModel> userList = new ArrayList<UserModel>(); //List to hold the data of all the users


    public LoginScreen(){ //Generating the required objects and adding the objects
        panel1 = new JPanel();
        panel2 = new JPanel();
        Container c = getContentPane();

        Color col = new Color(113,103,124);

        panel1.setBackground(col);
        panel2.setBackground(col);
        c.setLayout(new GridLayout(2,1));
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());

        c.add(panel1);
        c.add(panel2);

        usernameLogin = new JTextField(20);
        usernameRegister = new JTextField(20);


        dropDownList = new JComboBox();
        dropDownList.addItem(new FreeSubscription().toString());
        dropDownList.addItem(new SilverSubscription().toString());
        dropDownList.addItem(new GoldSubscription().toString());


        passwordLogin = new JPasswordField(20);
        passwordRegister = new JPasswordField(20);

        usernameLabel = new JLabel("username : ");
        passwordLabel = new JLabel("password : ");
        registerUsername = new JLabel("username : ");
        registerPassword = new JLabel("password : ");

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");


        panel1.add(usernameLabel);
        panel1.add(usernameLogin);

        panel1.add(passwordLabel);
        panel1.add(passwordLogin);

        panel1.add(loginButton);


        panel2.add(registerUsername);
        panel2.add(usernameRegister);

        panel2.add(registerPassword);
        panel2.add(passwordRegister);

        panel2.add(registerButton);
        panel2.add(dropDownList);

        MyEventHandler eventHandler = new MyEventHandler();
        loginButton.addActionListener(eventHandler);
        registerButton.addActionListener(eventHandler);
        pack();
    }


    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource() == loginButton ){
                    if (usernameLogin.getText().isEmpty() || passwordLogin.getText().isEmpty()) { //checking if username or password is empty
                    JOptionPane.showMessageDialog(null,
                            "Username and password can not be empty");

                    }else { //checking if the username and password is correct
                        boolean isLogged = false; //using a boolean to prevent multiple incorrect username or password outputs
                    for (UserModel user : userList) {
                        if(user.getUsername().equals(usernameLogin.getText()) &&
                                user.getPassword().equals(passwordLogin.getText())){
                            try {
                                loadMainScreen(user);
                            }
                            catch(Exception e){
                                System.err.println(e);
                            }
                            isLogged = true;
                        }

                    }
                    if(isLogged == false)
                        JOptionPane.showMessageDialog(null,"Username or password is incorrect");
                }
            }
            else if(actionEvent.getSource() == registerButton){
                UserModel user = new UserModel(usernameRegister.getText(),passwordRegister.getText(),getDropdownList());
                if(!userList.contains(user)) { //checking if the user already exist
                    userList.add(user);
                    clearRegisterTextField();
                    JOptionPane.showMessageDialog(null,"User registered successfully");

                }
                else{
                    JOptionPane.showMessageDialog(null, "User already exists");
                }

            }
        }
        private void clearRegisterTextField(){ //clearing the text field after registeration
            usernameRegister.setText("");
            passwordRegister.setText("");
        }
        public SubscriptionModel getDropdownList(){

            if(dropDownList.getSelectedItem().toString().equals("Free Subscription"))
                return new FreeSubscription();
            else if(dropDownList.getSelectedItem().toString().equals("Silver Subscription"))
                return new SilverSubscription();
            else
                return new GoldSubscription();
        }

        public void loadMainScreen(UserModel user){
            MainScreen mainScreen = new MainScreen(user);
            setVisible(false);
            mainScreen.setTitle("Video Broadcaster");
            mainScreen.setSize(800,600);
            mainScreen.setResizable(false);
            mainScreen.setVisible(true);
            mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }
}

