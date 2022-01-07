import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
    
    JLabel nameLabel=new JLabel("NAME");
    
    JLabel ageLabel=new JLabel("Age");
    JLabel mobileLabel=new JLabel("MOBILE NO");
    JLabel fromLabel=new JLabel("FROM");
    JLabel toLabel=new JLabel("TO");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
    
    JTextField ageTextField=new JTextField();
    JTextField mobileField=new JTextField();
    JTextField fromField=new JTextField();
    JTextField toTextField=new JTextField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");


    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Bus ticket booking system");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
        
        ageLabel.setBounds(20,120,100,70);
        mobileLabel.setBounds(20,170,100,70);
        fromLabel.setBounds(20,220,140,70);
        toLabel.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        
        ageTextField.setBounds(180,143,165,23);
        mobileField.setBounds(180,193,165,23);
        fromField.setBounds(180,243,165,23);
        toTextField.setBounds(180,293,165,23);
        emailTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        
        frame.add(ageLabel);
        frame.add(mobileLabel);
        frame.add(fromLabel);
        frame.add(toLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        
        frame.add(ageTextField);
        frame.add(mobileField);
        frame.add(fromField);
        frame.add(toTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
        	try {
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","abc@123");
                PreparedStatement Pstatement=connection.prepareStatement("insert into booking values(?,?,?,?,?,?)");
                Pstatement.setString(1,nameTextField.getText());
                
                Pstatement.setString(3,ageTextField.getText());
                Pstatement.setString(4,mobileField.getText());
                Pstatement.setString(5,fromField.getText());
                Pstatement.setString(6,toTextField.getText());
                Pstatement.setString(7,emailTextField.getText());

int i=Pstatement.executeUpdate();
JOptionPane.showMessageDialog(null,"Thank You!");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }
        if(e.getSource()==resetButton)
        {
            nameTextField.setText("");
           
            ageTextField.setText("");
            mobileField.setText("");
            fromField.setText("");
            toTextField.setText("");
            emailTextField.setText("");
        }

    }
}
