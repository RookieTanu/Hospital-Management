package hospital.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;


    Login(){
        //Username Label
        JLabel namelabel=new JLabel("Username");
        namelabel.setBounds(40, 20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        //Password Label
        JLabel password =new JLabel("Password");
        namelabel.setBounds(40,70,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(password);

        //Username TextField
        textField=new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(173,216,230));
        add(textField);

        //Password Field
        jPasswordField=new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        jPasswordField.setBackground(new Color(173, 216, 230));
        add(jPasswordField);


        //Image Icon
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/login p3.png"));
        Image i1 =imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(320,-30,400,300);
        add(label);

        //Login Button
        b1=new JButton( "Login");
        b1.setBounds (40, 140, 120, 30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        add(b1);

        //Cancel Button
        b2=new JButton( "Cancel");
        b2.setBounds( 180, 140, 120, 30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setForeground(Color.white);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        add(b2);

        //Frame setting
        getContentPane().setBackground(new Color(109,164,170));
        setSize(  750,  300);
        setLocation(750,0);
        setLayout(null);
        setVisible(true);


    }
    public static void main(String[]args){
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==b1){
            try{
                conn c=new conn();
                String user=textField.getText();
                String Pass=jPasswordField.getText();

                String q="select * from login where ID='"+user+"' and PW ='"+Pass+"'";
                ResultSet resultSet=c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }


            }catch(Exception E){
                E.printStackTrace();
            }

        }else{
            System.exit(10);

        }


    }
}
