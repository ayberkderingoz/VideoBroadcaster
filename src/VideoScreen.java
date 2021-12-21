import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VideoScreen extends JFrame {

    private JLabel label;
    private JButton backButton;
    private UserModel currentUser;
    public VideoScreen(UserModel user){
        getContentPane().setBackground(new Color(0,0,0));
        label = new JLabel("Video is playing with " + user.getSubscriptionModel().qualitySetting
        +" resolution.");
        label.setForeground(Color.white);
        getContentPane().add(label);
        backButton = new JButton("Back");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(backButton);

        MyEventHandler eventHandler = new MyEventHandler();
        backButton.addActionListener(eventHandler);
        currentUser = user;

        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        System.exit(0);
                    }
                }
        );

    }


    public class MyEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            if(actionEvent.getSource() == backButton){
                loadMainScreen(currentUser);

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
    }
}
