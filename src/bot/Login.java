package bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login implements ActionListener {
    JFrame f;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton B1,B2,B3;
    Connection con;
    Statement st;
    ResultSet Rs;
    {
        try {

            con = ConProvider.getConnection();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"connection failed rebbot system plz","emulation",0);
        }
    }
    Login() throws ClassNotFoundException {
        f=new JFrame();
        f.setLayout(null);
        Color c = new Color(150,120,100);
        f.setBackground(c);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel("username");
        l1.setBackground(Color.white);
        l1.setForeground(Color.black);
        l1.setBounds(150,250,100,20);
        f.add(l1);

        l2=new JLabel("password");
        l2.setBackground(Color.white);
        l2.setForeground(Color.black);
        l2.setBounds(150,310,100,20);
        f.add(l2);

        t1=new JTextField("");
        t1.setBounds(300,250,150,20);
        f.add(t1);

        t2=new JTextField("");
        t2.setBounds(300,310,150,20);
        f.add(t2);


        B1=new JButton("Submit");
        B1.setBounds(390,500,80,20);
        f.add(B1);

        B2=new JButton("Cancel");
        B2.setBounds(500,500,80,20);
        f.add(B2);

        B3=new JButton("new user");
        B3.setBounds(100,500,150,20);
        f.add(B3);

        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);

        f.setBounds(100,50,650,600);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object ob=ae.getSource();
        if(ob==B3){
            f.setVisible(false);
            NewUser A = new NewUser();
        }
        if(ob==B2){
            int yy= JOptionPane.showConfirmDialog(null,"do you want to exit","emulation",0);
            if (yy==0){
                System.exit(0);
            }
        }
        if(ob==B1){
            try {
                String username,password;
                username=t1.getText();
                password=t2.getText();
               PreparedStatement ps = con.prepareStatement("select * from bot_user where Username =? and Password=?");
               ps.setString(1,username);
               ps.setString(2,password);
               Rs=ps.executeQuery();
                boolean chk=false;
                if(Rs.next()){
                    String name=Rs.getString("Name");
                    f.setVisible(false);
                    Bot B =new Bot(name);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"user not found check username and password","emulation",0);
                }
                t1.setText("");
                t2.setText("");

            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"network error occured","emulation",0);


            }
        }
    }
}
