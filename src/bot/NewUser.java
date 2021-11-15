package bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class NewUser implements ActionListener {
    JFrame f;
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JPasswordField t8;
    JButton B1,B2;
    Connection con;
    {
        con = ConProvider.getConnection();
    }
    NewUser(){
        f =new JFrame();
        f.setLayout(null);
        Color c = new Color(150,120,100);
        f.setBackground(c);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        l0 = new JLabel("Registeration ");
        l0.setBackground(Color.white);
        l0.setForeground(Color.black);
        l0.setBounds(150,50,100,20);
        f.add(l0);

        l1 = new JLabel("Name");
        l1.setBackground(Color.white);
        l1.setForeground(Color.black);
        l1.setBounds(150,100,100,20);
        f.add(l1);

        l2=new JLabel("Email");
        l2.setBackground(Color.white);
        l2.setForeground(Color.black);
        l2.setBounds(150,150,100,20);
        f.add(l2);

        l3=new JLabel("AAdhar Number");
        l3.setBackground(Color.white);
        l3.setForeground(Color.black);
        l3.setBounds(150,200,100,20);
        f.add(l3);

        l4=new JLabel("City");
        l4.setBackground(Color.white);
        l4.setForeground(Color.black);
        l4.setBounds(150,250,100,20);
        f.add(l4);

        l5=new JLabel("State");
        l5.setBackground(Color.white);
        l5.setForeground(Color.black);
        l5.setBounds(150,300,100,20);
        f.add(l5);

        l6=new JLabel("Contact number");
        l6.setBackground(Color.white);
        l6.setForeground(Color.black);
        l6.setBounds(150,350,100,20);
        f.add(l6);

        l7=new JLabel("Username");
        l7.setBackground(Color.white);
        l7.setForeground(Color.black);
        l7.setBounds(150,400,100,20);
        f.add(l7);

        l8=new JLabel("Password");
        l8.setBackground(Color.white);
        l8.setForeground(Color.black);
        l8.setBounds(150,450,100,20);
        f.add(l8);


        t1=new JTextField("");
        t1.setBounds(300,100,150,20);
        f.add(t1);

        t2=new JTextField("");
        t2.setBounds(300,150,150,20);
        f.add(t2);

        t3=new JTextField("");
        t3.setBounds(300,200,150,20);
        f.add(t3);

        t4=new JTextField("");
        t4.setBounds(300,250,150,20);
        f.add(t4);

        t5=new JTextField("");
        t5.setBounds(300,300,150,20);
        f.add(t5);

        t6=new JTextField("");
        t6.setBounds(300,350,150,20);
        f.add(t6);

        t7=new JTextField("");
        t7.setBounds(300,400,150,20);
        f.add(t7);

        t8=new JPasswordField("");
        t8.setBounds(300,450,150,20);
        f.add(t8);

        B1=new JButton("Submit");
        B1.setBounds(390,500,80,20);
        f.add(B1);

        B2=new JButton("Cancel");
        B2.setBounds(500,500,80,20);
        f.add(B2);

        B1.addActionListener(this);
        B2.addActionListener(this);

        f.setBounds(100,50,650,600);
        f.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
              Object ob = e.getSource();
              if(ob==B2){
                  int yy= JOptionPane.showConfirmDialog(null,"do you want to exit","emulation",0);
                  if (yy==0){
                      System.exit(0);
                  }
              }
              if(ob==B1){
                  String Name= t1.getText();
                  String Email=t2.getText();
                  long  Aadhar=Long.parseLong(t3.getText());
                  String City=t4.getText();
                  String State=t5.getText();
                  long  Contact=Long.parseLong(t6.getText());
                  String Username=t7.getText();
                  char[] p=t8.getPassword();
                  String Password = new String(p);

                  int status= RegisterDao.save(Name,Email,Aadhar,City,State,Contact,Username,Password);
                  if(status>0){
                    f.setVisible(false);
                    Bot a= new Bot(Name);
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"Something went wrong","emulation",0);
                  }
              }
    }
}
