package bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bot extends JFrame implements ActionListener {
    String record,comp;
    String name;
    String state;
    JScrollPane sp,sp2;
    JFrame frame;
    JLabel l1;
    JComboBox cb;
    JButton post,register,print;
    JTextArea chatArea=new JTextArea();
    JTextField chatBox =new JTextField();
    JTextArea complaint;
    Connection con;
    ResultSet rs;
    Bot(String name){

        this.name=name;
        record = name+"\n";
        frame =new JFrame();
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.setTitle("ChatBot");

      l1=new JLabel("Welcome, "+name);
      l1.setBounds(400,10,200,30);
      frame.add(l1);

      chatArea.setEnabled(false);
      chatArea.setBackground(Color.BLACK);
      sp=new JScrollPane(chatArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      sp.setBounds(50,50,500,400);
      frame.add(sp);

      chatBox.setBounds(50,500,430,30);
      chatBox.requestFocus();
      frame.add(chatBox);
      chatBox.addActionListener(this);

      post =new JButton("Post");
      post.setBounds(490,500,80,30);
      frame.add(post);
      post.addActionListener(this);

      chatArea.append("Welcome to Complaint Registration Portal \n");

      String state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Andaman and Nicobar Islands","Bihar","Chandigarh","Chattisgarh","Delhi","Daman & Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Jammu and Kashmir","Karnataka","Kerala","Ladakh","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Puducherry","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal"};
      cb=new JComboBox(state);
      cb.setBounds(50,500,250,30);
      cb.addActionListener(this);
      frame.add(cb);
      cb.setVisible(false);

      complaint=new JTextArea();
      sp2=new JScrollPane(complaint,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      sp2.setBounds(50,470,430,170);
      frame.add(sp2);
      sp2.setVisible(false);

      register =new JButton("Submit");
      register.setBounds(490,530,100,30);
      frame.add(register);
      register.addActionListener(this);
      register.setVisible(false);

      print =new JButton("Print ");
      print.setBounds(290,530,100,30);
      frame.add(print);
      print.addActionListener(this);
      print.setVisible(false);


        frame.setLayout(null);
      frame.setVisible(true);
     // frame.setResizable(false);
      frame.setSize(630,700);

    }
    private void bot(String s2){
        chatArea.append("Bot-> "+s2+"\n");

    }
    private void printState(){
        chatArea.append("Bot-> "+"Select State"+"\n");
        chatBox.setVisible(false);
        cb.setVisible(true);
//        String state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Andaman and Nicobar Islands","Bihar","Chandigarh","Chattisgarh","Delhi","Daman & Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Jammu and Kashmir","Karnataka","Kerala","Ladakh","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Puducherry","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal"};
//        cb=new JComboBox(state);
//        cb.setBounds(50,500,250,30);
//        cb.addActionListener(this);
//        frame.add(cb);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        if(ob==print){

            ///// here we will write code to print
        }
        if(ob==register){
            comp=complaint.getText();
            chatArea.append("YOU ->"+"your complaint is "+comp+"\n");
            bot("if want to rewrite complaint press 3 or to move forward press 4");
            sp2.setVisible(false);
            register.setVisible(false);
            chatBox.setVisible(true);
            post.setVisible(true);

        }
        if(ob==post){
            String value=getFieldValue();
            reply(value);
        }
        if(ob==cb){
             state = String.valueOf(cb.getSelectedItem());
             bot("Selected "+state);
             record=record+state;
             cb.setVisible(false);
             chatBox.setVisible(true);
             chatBox.requestFocus();
             bot("Press 1 to reset state else Press 2 to move forward");
        }
        }

    private void reply(String value) {
        boolean p=isValidPinCode(value);
        if(isValidPinCode(value)){
             bot("Pin-Code Registered Successfully");
             bot("Write your Complaint in words");
             printComplaint();
        }
        else{
            if(value.equals("hi")||value.equals("hello")||value.equals("namaste")||value.equals("hey")||value.equals("help me")){
                bot("Hello");
                bot("Cyber Police is Ready to Register your Complaint");
                bot("Firstly Select your state");
                printState();
            }
            else if(value.equals("1")){
                bot("Don't be panic select state again");
                printState();
            }
            else if(value.equals("2")){
                bot("Type Pin-code of incident area");
                chatBox.requestFocus();
            }
            else if(value.equals("3")){
                bot("Write complaint again");
                complaint.setText("");
                printComplaint();
            }
            else if(value.equals("4")){
                bot("Complaint Registered Successfully");
                printPage();
            }
            else{
                bot("Something went wrong invalid information");
                bot("type hi || hello something like that");
                chatBox.requestFocus();
            }
            }
        }

    private void printPage() {
        bot("Click on Print Button to print your page");
        chatBox.setVisible(false);
        post.setVisible(false);
        print.setVisible(true);
    }

    private void printComplaint() {
        chatBox.setVisible(false);
        post.setVisible(false);
        sp2.setVisible(true);
        register.setVisible(true);

    }

    public static boolean isValidPinCode(String pinCode)
    {

        // Regex to check valid pin code of India.
        String regex
                = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the pin code is empty
        // return false
        if (pinCode == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given pin code
        // and regular expression.
        Matcher m = p.matcher(pinCode);

        // Return if the pin code
        // matched the ReGex
        return m.matches();
    }
    String getFieldValue(){
            String s1=chatBox.getText();
            chatArea.append("YOU-> "+s1+"\n");
            chatBox.setText("");
            return s1;
        }
}

