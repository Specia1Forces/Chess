package GameOfChessFinal.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI2 {

    public static JFrame frame2;
    public static JButton b2;
    public JLabel hello2;

    GUI2(){

        frame2 = new JFrame();
        frame2.setSize(1920, 1080);
        frame2.setResizable(false);
        frame2.setTitle("FRAM2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(main.frame1); //
        frame2.setLayout(null);
        frame2.setVisible(true);

        b2 = new JButton("Got to Frame 1");
        b2.setBounds(100,300,200,50);
        b2.addActionListener(main.handler);
        frame2.add(b2);

        hello2 = new JLabel("Hello Frame 2");
        hello2.setBounds(100,100,100,20);
        frame2.add(hello2);
    }

}