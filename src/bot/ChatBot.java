package bot;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ChatBot {
    JFrame f;
    JLabel l1,l2,l3,l4;
    JProgressBar Pb;
    ImageIcon I;
    ChatBot(){
        f=new JFrame();
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        I=new ImageIcon("C:\\Users\\Rohit mittal\\IdeaProjects\\chatbot\\src\\images3.jfif");
        l4 =new JLabel("",JLabel.CENTER);
        l4.setIcon(I);
        l4.setBounds(140,40,500,500);
        f.add(l4);

        l1=new JLabel("Loading");
        l1.setBounds(300,650,200,15);
        f.add(l1);

        l2=new JLabel("www.loremipsum.com");
        l2.setBounds(300,500,200,20);
        f.add(l2);

        l3=new JLabel("Indian Cyber Police");
        Font f1 =new Font("TimesNewRoman",Font.BOLD,30);
        l3.setFont(f1);
        l3.setBounds(250,90,300,50);
        f.add(l3);

        Pb=new JProgressBar(1,100);
        Pb.setBounds(50,600,600,30);
        f.add(Pb);

        f.setBounds(100,50,800,760);
        f.setVisible(true);
        for (int i=1;i<=100;i=i+10){
            try {
                Thread.sleep(500);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"error occured ","emulation",0);

            }
            Pb.setValue(i);

        }
        f.setVisible(false);

        try {
            Login A=new Login();
        }
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"error occured ","emulation",0);
        }


    }

    public static void main(String[] args) {
        ChatBot B=new ChatBot();
    }

}
