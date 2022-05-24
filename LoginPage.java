import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class LoginPage implements ActionListener{

    JFrame frame = new JFrame();

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("User Id");
    JLabel userPasswordlabel = new JLabel("Password");
    JLabel messJLabel = new JLabel();

    HashMap<String,String> logininfo = new HashMap<String,String>();

    LoginPage(HashMap<String,String> loginInfoOrignal){
        logininfo = loginInfoOrignal;

        userIdLabel.setBounds(50,100,75,25);
        userPasswordlabel.setBounds(50,150,75,25);
        messJLabel.setBounds(125,250,250,35);
        messJLabel.setFont(new FontUIResource(null,Font.BOLD,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(userIdLabel);
        frame.add(userPasswordlabel);
        frame.add(messJLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource()==loginButton){
            String userId = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userId)){
                if(logininfo.get(userId).equals(password)){
                    messJLabel.setForeground(Color.green);
                    messJLabel.setText("Login Succesfull..");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userId);
                }
                else{
                    messJLabel.setForeground(Color.red);
                    messJLabel.setText("Wrong Password..");
                }
            }
            else{
                messJLabel.setForeground(Color.red);
                messJLabel.setText("Invalid Username..");
            }
        }

    }
}
