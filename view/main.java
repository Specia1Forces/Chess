package GameOfChessFinal.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main {
    public static JFrame frame1;

   JLabel hello1;

    JButton b1;


    static Handler handler;


    main(){
        frame1 = new JFrame();
        frame1.setSize(1920, 1080);
        frame1.setResizable(false);
        frame1.setTitle("Main");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(GUI2.frame2);
        frame1.setLayout(null);
        frame1.setVisible(true);


        handler = new Handler();
        MyPanel myPanel = new MyPanel();
        hello1 = new JLabel("Hello Frame 1");
        hello1.setBounds(100,100,100,20);
        frame1.add(hello1);
        frame1.setBackground(Color.ORANGE);


        b1 = new JButton("Go to Frame 2");
        b1.setBounds(100,300,200,50);
        b1.addActionListener(handler);
        frame1.add(b1);


    }

    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {

                new GUI2();

                frame1.setVisible(false);
                frame1.dispose();

            }if(e.getSource() == GUI2.b2) {


                new main();


                GUI2.frame2.setVisible(false);
                GUI2.frame2.dispose();
            }


        }

    }

    public static void main(String args[]) {
        new main();
    }

}
