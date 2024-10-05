package GameOfChessFinal.view;

import GameOfChessFinal.model.GameField;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

public class MyPanel extends JPanel {
    public MyPanel() {

        JLabel hello1 = new JLabel("Hello Frame 1");
        hello1.setBounds(100,100,100,20);

        JButton buttonGMenu = new JButton("ГЛАВНОЕ МЕНЮ");
        JButton buttonPrevMove = new JButton("ПРЕДЫДУЩИЙ ХОД");

        buttonGMenu.setBounds(1100, 20, 420, 75); //x y длина и ширина
        buttonPrevMove.setBounds(1100, 120, 420, 75);
        add(buttonGMenu);
        add(buttonPrevMove);
        setLayout(null);
        setBackground(Color.orange);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // base
        g.setColor(Color.ORANGE);
        g.fillRect(300, 300, 200, 200);

        // roof
        g.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(400, 200);
        polygon.addPoint(280, 320);
        polygon.addPoint(520, 320);
        g.fillPolygon(polygon);

        // window
        g.setColor(new Color(8, 192, 233));
        g.fillRect(410, 370, 60, 60);

        // window bars
        g.setColor(Color.BLACK);
        g.fillRect(439, 370, 2, 60);
        g.fillRect(410, 399, 60, 2);

        // door
        g.setColor(new Color(133, 100, 4));
        g.fillRect(330, 410, 50, 90);

        // doorknob
        g.setColor(Color.BLACK);
        g.fillOval(335, 460, 5, 5);

        // bicycle
        g.drawOval(510, 460, 40, 40);
        g.drawOval(580, 460, 40, 40);

        g.drawPolygon(new int[]{530, 550, 570}, new int[]{480, 450 ,480}, 3);
        g.drawPolygon(new int[]{550, 590, 570}, new int[]{450, 450 ,480}, 3);

        g.drawLine(600, 480, 590, 450);
        g.drawLine(590, 440, 590, 450);
        g.drawLine(600, 440, 590, 440);

        g.drawLine(550, 450, 545, 443);
        g.drawLine(554, 443, 542, 443);


    }
}