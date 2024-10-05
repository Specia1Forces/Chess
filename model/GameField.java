package GameOfChessFinal.model;

import java.util.LinkedList;

public class GameField {

    static final int PAWNRED = -8;
    static final int PAWNBLUE = 8;

    static final int ROOKRED = -15;
    static final int ROOKBLUE = 15;

    static final int KNIGHTRED = -25;
    static final int KNIGHTBLUE = 25;

    static final int BISHOPRED = -50;
    static final int BISHOPBLUE = 50;

    static final int KINGRED = -64;
    static final int KINGBLUE = 64;

    static final int QUEENRED = -55;
    static final int QUEENBLUE = 55;


    int Width = 8;//ширина
    int Length = 8;//длина

    public int[][] gameField = new int[8][8];
    // int[][] gameActions = new int[8][8]; //лучше список
    public LinkedList<Point> gameActions = new LinkedList<Point>();
    public LinkedList<Point> gameFigureAttackKing = new LinkedList<Point>();
    public Point gameStartActions = new Point();

    boolean checkMate = false;

    public int[] pawns1 = new int[8];
    public int[] pawns2 = new int[8];

    public boolean gameOver = false;

    public int action = 0; //0 -- движение // 1 - атака
    public boolean player = true; //true - синие ,false - красные

    //нужны координаты фигур либо общая
    //формула i,j начальные координаты g.fillRect(250 + 65 * i, 120 + 65 * j, 65, 65);

    public GameField() {
        for (int i = 0; i < 8; i++) {
            gameField[i][1] = -8;//пешка +
            gameField[i][6] = 8;
        }
        gameField[0][0] = -15; //ладья  + танк
        gameField[7][0] = -15; //ладья  танк

        gameField[0][7] = 15; //ладья  танк
        gameField[7][7] = 15;//ладья   танк

        gameField[1][0] = -25; //лошадь + артиллерия
        gameField[6][0] = -25; //лошадь  артиллерия

        gameField[1][7] = 25; //лошадь   артиллерия
        gameField[6][7] = 25;//лошадь   артиллерия

        gameField[2][0] = -50; //слон +  вертолет
        gameField[5][0] = -50; //слон

        gameField[2][7] = 50; //слон  вертолет
        gameField[5][7] = 50;//слон  вертолет

        gameField[3][0] = -64; //король +
        gameField[3][7] = 64; //король

        gameField[4][0] = -55; //ферзь +
        gameField[4][7] = 55;//ферзь

    }


    public void Setter(int i, int j, int figure) {
        gameField[i][j] = figure;
    }

    public int Getter(int i, int j) {
        return gameField[i][j];
    }

    public void ResetActions() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //gameActions[i][j] = 0;
                gameActions.add(new Point(i, j));
            }
        }
    }


    public void SetActions(int i, int j) {
        gameActions.add(new Point(i, j));

    }

    public void setFigureAttackKing(int i, int j) {
        gameFigureAttackKing.add(new Point(i, j));
    }

    public int GetFigureAttackKingX(int i) {
        return gameActions.get(i).getX();
    }

    public int GetFigureAttackKingY(int i) {
        return gameActions.get(i).getY();
    }

    public void clearActions() {
        gameActions.clear();
    }

    public void clearAction(Point a) {
        gameActions.remove(a);
    }

    public int GetActions(int i, int j) {
        return gameField[i][j];
    }


    public int GetActionsX(int i) {

        return gameActions.get(i).getX();
    }

    public int GetActionsY(int i) {
        return gameActions.get(i).getY();
    }

    public void StartActions(int i, int j) {
        gameStartActions.setCoord(i, j);
    }

    public Point GetStartActions() {
        return gameStartActions;
    }

    public int GetStartActionsX() {

        return gameStartActions.getX();
    }

    public int GetStartActionsY() {

        return gameStartActions.getY();
    }

    public int[][] getGameField() {
        return gameField;
    }

    public int[][] getGameActions() {
        return gameField;
    }

    public void SetPawn(int i, int figure) {
        if (figure > 0) {
            pawns1[i] = 1;
            return;
        }
        pawns2[i] = 1;
    } //ош

    public int getPawn(int i, int figure) {
        if (figure > 0) {
            return pawns1[i];
        }
        return pawns2[i];
    } //ош

}
