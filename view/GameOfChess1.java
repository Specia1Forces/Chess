package GameOfChessFinal.view;

import GameOfChessFinal.model.Chess;
import GameOfChessFinal.model.GameField;
import GameOfChessFinal.model.Point;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;


public class GameOfChess1 extends JFrame {


    private JPanel panel;
    //  JFrame frame = new JFrame("example");
    GameField gameField = new GameField();
    Chess chess = new Chess(gameField);

    Point checkCoord = new Point(); //заменить на point

    public GameOfChess1(String title) {
        super(title);
        DrawChessboard panel = new DrawChessboard(gameField);
        Container c = getContentPane();
        panel.repaint();



        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("x=" + e.getX() + "y=" + e.getY());
                int x = e.getX();
                int y = e.getY();

                if ((x >= 250 && x <= 770) && (y >= 120 && y <= 640)) {
                    System.out.println("-------------");
                    //если вышли за границу,то ничего не делаем
                    int i = (int) ((float) (x - 250)) / 65;
                    int j = (int) ((float) (y - 120)) / 65;
                    System.out.println("i= " + i + " j= " + j);
                    System.out.println("-------------");
                    System.out.println("Фигура ="+gameField.Getter(i,j));
                    int pieces = gameField.Getter(i, j);
                    boolean motion = false;


                    if (pieces == 0) {
                    } else if (pieces > 0 && gameField.player) {
                        motion = true;
                        System.out.println("Cиние");
                    } else if (pieces < 0 && !gameField.player) {
                        motion = true;
                        System.out.println("КРАСНЫЕ");
                    }
                    // System.out.println("Cколько вариантво ходов?: " + gameField.gameActions.size());
                    if (gameField.gameActions.size() != 0) { // пропущена ли атака?
                        //     System.out.println("x=" + checkCoord.getX() + "y=" + checkCoord.getY());
                        for (int i1 = 0; i1 < gameField.gameActions.size(); i1++) {
                            //  System.out.println("x=" + gameField.GetActionsX(i1) + "y=" + gameField.GetActionsY(i1));

                            if (i == gameField.GetActionsX(i1) && j == gameField.GetActionsY(i1)) {
                                gameField.action = 1;

                                break;
                            } else {

                            }
                        }
                        motion=true;
                    }

                    if (motion) { //дела в motion
                        //    System.out.println("pfitk!!");
                        if (gameField.action == 0) {
                            gameField.clearActions();
                            switchMovePieces(gameField, i, j);
                            checkCoord.setCoord(i, j);
                            //    System.out.println("варианты ответов");
                        }
                        if (gameField.action == 1) {
                            //  System.out.println("атак1");
                            switchAttackPieces(gameField, i, j, gameField.Getter(checkCoord.getX(), checkCoord.getY()));
                            //  System.out.println("атака2");
                            gameField.action = 0;
                            gameField.clearActions();
                            gameField.player = !gameField.player;
                        }

                    }
                    panel.repaint();

                    //обновляем поле на основе текущей ситуации в партии
                }
            }
        });
        c.add(panel);
        setSize(1920, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        GameOfChess1 mw = new GameOfChess1("Chess"); //создали окно без ничего
    }



    private void switchMovePieces(GameField gameField, int i, int j) {
        switch (gameField.Getter(i, j)) {
            case -8, 8: //пешка
                chess.movePawn(i, j, gameField.Getter(i, j));
                break;
            case -15, 15: //ладья
                chess.moveRook(i, j, gameField.Getter(i, j));
                break;
            case -25, 25: //лошадь
                chess.moveKnight(i, j, gameField.Getter(i, j));
                break;
            case -50, 50: //слон
                chess.moveBishop(i, j, gameField.Getter(i, j));
                break;
            case -64, 64: //король
                chess.MoveKing(i, j, gameField.Getter(i, j));
                break;
            case -55, 55: //ферзь
                chess.moveQueen(i, j, gameField.Getter(i, j));
                break;
            default:

        }
    }

    private void switchAttackPieces(GameField gameField, int i, int j, int figure) {
        switch (figure) {
            case -8, 8: //пешка
                chess.attackPawn(i, j, figure);
                break;
            case -15, 15: //ладья
                chess.attackRook(i, j, figure);
                break;
            case -25, 25: //лошадь
                chess.attackKnight(i, j, figure);
                break;
            case -50, 50: //слон
                chess.attackBishop(i, j, figure);
                break;
            case -64, 64: //король
                chess.attackKing(i, j, figure);
                break;
            case -55, 55: //ферзь
                chess.attackQueen(i, j, figure);
                break;
            default:
        }
    }



}