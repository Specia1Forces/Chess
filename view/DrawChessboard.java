package GameOfChessFinal.view;
//нормальная версия

import GameOfChessFinal.model.Chess;
import GameOfChessFinal.model.GameField;
import GameOfChessFinal.model.Point;
import  GameOfChessFinal.io1.PartyFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawChessboard extends JPanel {


    GameField gameField;

    public DrawChessboard(GameField gameField) {

        this.gameField = gameField;

        JButton buttonGMenu = new JButton("ГЛАВНОЕ МЕНЮ");
        JButton saveParties = new JButton("Cохранить партию");

        buttonGMenu.setBounds(1100, 20, 420, 75); //x y длина и ширина
        saveParties.setBounds(1100, 120, 420, 75);
        add(buttonGMenu);
        add(saveParties);
        saveParties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("сохранили партию");
                PartyFiles partyFiles = new PartyFiles(gameField);
                partyFiles.saveChessGame("Russiaword");
            }
        });

        setLayout(null);
        setBackground(Color.orange);
    }

    public void paintComponent(Graphics g) {
        // System.out.println("paintComponent");
        super.paintComponent(g);

        g.setColor(new Color(181, 230, 29)); //рисуем шахматное поле
        boolean colorBool = true;
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (i != 0) {
                    if (colorBool) {
                        g.setColor(new Color(181, 230, 29));
                    } else {
                        g.setColor(new Color(34, 177, 76));
                    }
                }

                g.fillRect(250 + 65 * i, 120 + 65 * j, 65, 65);
                colorBool = !colorBool;

            }
            colorBool = !colorBool;
        }
        //рисуем шахматное поле
        //рисуем фигуры
        String figureName;
        Image img;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int figure = gameField.Getter(i, j);
                if (figure != 0) {
                    figureName = switchFigure(figure);
                    //img = Toolkit.getDefaultToolkit().getImage("res1\\" + figureName + ".png");//"F:\\Дмитрий\\IdeaProjects\\labs\\res1\\" + figureName + ".png"
                    img = Toolkit.getDefaultToolkit().getImage("res1\\" + figureName + ".png");
                    g.drawImage(img, 250 + 65 * i, 120 + 65 * j, null); //координаты доработать
                }

            }
            //рисуем фигуры
        }
        //рисуем варианты
        //System.out.println("Количество действий = "+gameField.gameActions.size()+" !");
        g.setColor(Color.red);
        for (int i = 0; i < gameField.gameActions.size(); i++) {
           // System.out.println("Рисует дейсвтия ");
            // System.out.println("x=" + gameField.GetActionsX(i) + "y=" + gameField.GetActionsY(i));
            g.drawRect(250 + 65 * gameField.GetActionsX(i), 120 + 65 * gameField.GetActionsY(i), 65, 65);
            //g.drawRect(250 + 65 * 5, 120 + 65 * 5, 65, 65);
        }

        //рисуем варианты

    }

    private String switchFigure(int figure) {
        switch (figure) {
            case -8, 8: //пешка
                if (figure == -8) {
                    return "redPawn";
                } else {
                    return "bluePawn";
                }

            case -15, 15: //ладья
                if (figure == -15) {
                    return "redRook";
                } else {
                    return "blueRook";
                }

            case -25, 25: //лошадь
                if (figure == -25) {
                    return "redKnight";
                } else {
                    return "blueKnight";
                }

            case -50, 50: //слон
                if (figure == -50) {
                    return "redBishop";
                } else {
                    return "blueBishop";
                }

            case -64, 64: //король
                if (figure == -64) {
                    return "redKing";
                } else {
                    return "blueKing";
                }

            case -55, 55: //ферзь
                if (figure == -55) {
                    return "redQueen";
                } else {
                    return "blueQueen";
                }
            default:
                return "";
        }
    }
}

