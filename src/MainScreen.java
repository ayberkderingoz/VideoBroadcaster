import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends JFrame{
    private JPanel panel1,panel2,panel3,panel4;
    private JLabel label1,label2,label3,label4;
    private JScrollPane scrPane;
    private List<Movie> movieList = new ArrayList<>();
    private JButton editUserButton;
    private static UserModel currentUser;

    public MainScreen(UserModel user){

        Container c = getContentPane();
        c.setPreferredSize(new Dimension(800,600));
        c.setLayout(new FlowLayout());
        Color col = new Color(113,103,124);
        c.setBackground(col);

        editUserButton = new JButton("Edit User");


        currentUser = user;
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.setPreferredSize(new Dimension(800,1200));
        panel2.setBackground(col);


        scrPane = new JScrollPane(panel2);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrPane.setPreferredSize(new Dimension(780,600));
        c.add(scrPane);

        label1 = new JLabel("Movies");


        panel1 = new JPanel();
        panel1.add(label1);
        panel1.add(editUserButton);
        panel1.setBackground(col);
        panel1.setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(800,30));

        panel2.add(panel1);


        for(String genre : user.getSubscriptionModel().genreList ){
            panel2.add(createLabel(genre));
            panel2.add(createPanel(user));
            System.out.println(genre);
        }
    pack();

    MyEventHandler eventHandler = new MyEventHandler();
    editUserButton.addActionListener(eventHandler);

    }
    public JPanel createLabel(String genre){ //creating the labels with the genres that user has
        JLabel label = new JLabel(genre);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(113,103,124));
        panel.add(label);
        panel.setPreferredSize(new Dimension(800,30));
        return panel;
    }
    public JPanel createPanel(UserModel userModel){ //creating a panel and adding 3 Movie object and adding the listeners
        JPanel panel = new JPanel();
        Movie movie1 = new Movie(true,userModel.getSubscriptionModel());
        Movie movie2 = new Movie(true,userModel.getSubscriptionModel());
        Movie movie3 = new Movie(true,userModel.getSubscriptionModel());
        panel.add(movie1);
        panel.add(movie2);
        panel.add(movie3);
        panel.setLayout(new FlowLayout());
        pack();
        PanelListener listener = new PanelListener();
        movie1.addMouseListener(listener);
        movie2.addMouseListener(listener);
        movie3.addMouseListener(listener);
        panel.setBackground(new Color(169,159,150));
        return panel;
    }
    public void loadVideoScene(){
        VideoScreen videoScreen = new VideoScreen(currentUser);
        setVisible(false);
        videoScreen.setTitle("Video Broadcaster");
        videoScreen.setSize(800,600);
        videoScreen.setResizable(false);
        videoScreen.setVisible(true);
        videoScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class PanelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) { //getting the chosen movie

            Object source = event.getSource();
            if (source instanceof Movie) {
                Movie panelPressed = (Movie) source;
                loadVideoScene();
            }
        }
        @Override
        public void mouseEntered(MouseEvent arg0) {}

        @Override
        public void mouseExited(MouseEvent arg0) {}

        @Override
        public void mousePressed(MouseEvent arg0) {}

        @Override
        public void mouseReleased(MouseEvent arg0) {}


    }

    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource()== editUserButton){
                laodEditUserScreen(currentUser);
            }
        }
        public void laodEditUserScreen(UserModel user){ //Goes to the edit user screen
            EditUserScreen editUser = new EditUserScreen(user);
            setVisible(false);
            editUser.setTitle("Video Broadcaster");
            editUser.setSize(400,300);
            editUser.setResizable(false);
            editUser.setVisible(true);
            editUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
