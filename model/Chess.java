package GameOfChessFinal.model;

import java.util.*;

public class Chess {

    GameField gameField;

    public Chess(GameField gameField) {
        this.gameField = gameField;
    }

    //рисовать можно не тут)
    public void MoveKing(int i, int j, int figure) {
        gameField.StartActions(i, j);

        if (i - 1 >= 0) { // левая часть
            if (j - 1 >= 0) {
                if ((gameField.Getter(i - 1, j - 1) == 0)) { //никого нет дальше идем
                    gameField.SetActions(i - 1, j - 1);
                } else if (whoseFigure(gameField.Getter(i - 1, j - 1), figure)) { //если есть чужой
                    gameField.SetActions(i - 1, j - 1);
                }
            }

            if (j + 1 < 8) {
                if ((gameField.Getter(i - 1, j + 1) == 0)) { //никого нет дальше идем
                    gameField.SetActions(i - 1, j + 1);
                } else if (whoseFigure(gameField.Getter(i - 1, j + 1), figure)) { //если есть чужой
                    gameField.SetActions(i - 1, j + 1);
                }
            }

            if ((gameField.Getter(i - 1, j) == 0)) { //никого нет дальше идем
                gameField.SetActions(i - 1, j);
            } else if (whoseFigure(gameField.Getter(i - 1, j), figure)) { //если есть чужой
                gameField.SetActions(i - 1, j);
            }
        }

        if (i + 1 < 8) {  // может неправильно
            if (j - 1 >= 0) {
                if ((gameField.Getter(i + 1, j - 1) == 0)) { //никого нет дальше идем
                    gameField.SetActions(i + 1, j - 1);
                } else if (whoseFigure(gameField.Getter(i + 1, j - 1), figure)) { //если есть чужой
                    gameField.SetActions(i + 1, j - 1);
                }
            }

            if (j + 1 < 8) {
                if ((gameField.Getter(i + 1, j + 1) == 0)) { //никого нет дальше идем
                    gameField.SetActions(i + 1, j + 1);
                } else if (whoseFigure(gameField.Getter(i + 1, j + 1), figure)) { //если есть чужой
                    gameField.SetActions(i + 1, j + 1);
                }
            }

            if ((gameField.Getter(i + 1, j) == 0)) { //никого нет дальше идем
                gameField.SetActions(i + 1, j);
            } else if (whoseFigure(gameField.Getter(i + 1, j), figure)) { //если есть чужой
                gameField.SetActions(i + 1, j);
            }
        }

        if (j - 1 >= 0) {
            if ((gameField.Getter(i, j - 1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i, j - 1);
            } else if (whoseFigure(gameField.Getter(i, j - 1), figure)) { //если есть чужой
                gameField.SetActions(i, j - 1);
            }
            //рисует
        }
        if (j + 1 < 8) {
            if ((gameField.Getter(i, j + 1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i, j + 1);
            } else if (whoseFigure(gameField.Getter(i, j + 1), figure)) { //если есть чужой
                gameField.SetActions(i, j + 1);
            }
        }
        // ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Point> tempGameActions = new LinkedList<Point>();
        if (gameField.gameActions.size() != 0) {   //проверка под ударом ли фигура
            int g;
            for (g = 0; g < gameField.gameActions.size(); g++) {//проверяет
                if (checkKingAttack(gameField.gameActions.get(g).getX(), gameField.gameActions.get(g).getY(), figure)) {
                    // arrayList.add(g);
                    tempGameActions.add(gameField.gameActions.get(g));
                    // gameField.clearAction(gameField.gameActions.get(g));
                }

            }
            gameField.gameActions.clear();
            gameField.gameActions = tempGameActions;

        }

    }

    public boolean checkKingAttack(int i, int j, int figure) {

        //проверка на коня

        if (i - 2 >= 0 && j - 1 >= 0 && (Math.abs(gameField.Getter(i - 2, j - 1)) == 25)) { //+ +

            if (whoseFigure(gameField.Getter(i - 2, j - 1), figure)) { //если есть чужой

                return false;
            }
        }
        if (i - 1 >= 0 && j - 2 >= 0 && (Math.abs(gameField.Getter(i - 1, j - 2)) == 25)) {

            if (whoseFigure(gameField.Getter(i - 1, j - 2), figure)) { //если есть чужой
                return false;
            }
        }

        if (i + 1 < 8 && j - 2 >= 0 && (Math.abs(gameField.Getter(i + 1, j - 2)) == 25)) {
            if (whoseFigure(gameField.Getter(i + 1, j - 2), figure)) { //если есть чужой
                return false;
            }
        }

        if (i + 2 < 8 && j - 1 >= 0 && (Math.abs(gameField.Getter(i + 2, j - 1)) == 25)) {

            if (whoseFigure(gameField.Getter(i + 2, j - 1), figure)) { //если есть чужой

                return false;
            }
        }
        ///—————-
        if (i + 2 < 8 && j + 1 < 8 && (Math.abs(gameField.Getter(i + 2, j + 1)) == 25)) {

            if (whoseFigure(gameField.Getter(i + 2, j + 1), figure)) { //если есть чужой

                return false;
            }
        }
        if (i + 1 < 8 && j + 2 < 8 && (Math.abs(gameField.Getter(i + 1, j + 2)) == 25)) {

            if (whoseFigure(gameField.Getter(i + 1, j + 2), figure)) { //если есть чужой

                return false;
            }
        }

        if (i - 1 >= 0 && j + 2 < 8 && (Math.abs(gameField.Getter(i - 1, j + 2)) == 25)) {

            if (whoseFigure(gameField.Getter(i - 1, j + 2), figure)) { //если есть чужой

                return false;
            }
        }
        if (i - 2 >= 0 && j + 1 < 8 && (Math.abs(gameField.Getter(i - 2, j + 1)) == 25)) {

            if (whoseFigure(gameField.Getter(i - 2, j + 1), figure)) { //если есть чужой

                return false;
            }
        }


        int i1;
        for (i1 = i + 1; i1 < 8; i1++) { // по горизонтали
            // i y ; j - cosnt

            if (Math.abs(gameField.Getter(i1, j)) == 55 || Math.abs(gameField.Getter(i1, j)) == 15) {

                if (whoseFigure(gameField.Getter(i1, j), figure)) { //если есть чужой

                    return false;
                } else {

                    i1 = 9;
                }
            } else if (Math.abs(gameField.Getter(i1, j)) != 0) {

                break;
            }
        }
        for (i1 = i - 1; i1 >= 0; i1--) {  // по горизонтали

            if (Math.abs(gameField.Getter(i1, j)) == 55 || Math.abs(gameField.Getter(i1, j)) == 15) {

                if (whoseFigure(gameField.Getter(i1, j), figure)) { //если есть чужой

                    return false;
                } else {

                    i1 = -1;
                }
            } else if (Math.abs(gameField.Getter(i1, j)) != 0) {

                break;
            }
        }
        int j1;
        for (j1 = j + 1; j1 < 8; j1++) {  // по вертикали

            if (Math.abs(gameField.Getter(i, j1)) == 55 || Math.abs(gameField.Getter(i, j1)) == 15) {

                if (whoseFigure(gameField.Getter(i, j1), figure)) { //если есть чужой

                    return false;
                } else {

                    j1 = 8;
                }
            } else if (Math.abs(gameField.Getter(i, j1)) != 0) {

                break;
            }
        }
        for (j1 = j - 1; j1 >= 0; j1--) { // по вертикали

            if (Math.abs(gameField.Getter(i, j1)) == 55 || Math.abs(gameField.Getter(i, j1)) == 15) {

                if (whoseFigure(gameField.Getter(i, j1), figure)) { //если есть чужой

                    return false;
                } else {

                    j1 = -1;
                }
            } else if (Math.abs(gameField.Getter(i, j1)) != 0) {

                break;
            }
        }


        //по диагонали

        int coordX1 = i;
        int coordY1 = j;

        int coordX2 = i;
        int coordY2 = j;

        int coordX3 = i;
        int coordY3 = j;

        int coordX4 = i;
        int coordY4 = j;

        while (true) { //+
            if (--coordX1 < 0) break;


            if (--coordY1 < 0) break;


            if (Math.abs(gameField.Getter(coordX1, coordY1)) == 55 || Math.abs(gameField.Getter(coordX1, coordY1)) == 50) {

                if (whoseFigure(gameField.Getter(coordX1, coordY1), figure)) { //если есть чужой

                    return false;
                } else {

                    coordX1 = -1;
                }
            } else if (Math.abs(gameField.Getter(coordX1, coordY1)) != 0) {

                break;
            }

        }
        while (true) { //+
            if (++coordX2 > 7) break;

            if (--coordY2 < 0) break;

            if (Math.abs(gameField.Getter(coordX2, coordY2)) == 55 || Math.abs(gameField.Getter(coordX2, coordY2)) == 50) {
                if (whoseFigure(gameField.Getter(coordX2, coordY2), figure)) { //если есть чужой
                    return false;
                } else {

                    coordX2 = 8;
                }
            } else if (Math.abs(gameField.Getter(coordX2, coordY2)) != 0) {

                break;
            }

        }
        System.out.println("третья четверть");
        while (true) {
            if (--coordX3 < 0) break;
            if (++coordY3 > 7) break;


            if (Math.abs(gameField.Getter(coordX3, coordY3)) == 55 || Math.abs(gameField.Getter(coordX3, coordY3)) == 50) {

                if (whoseFigure(gameField.Getter(coordX3, coordY3), figure)) { //если есть чужой

                    return false;
                } else {

                    coordX3 = -1;
                }
            } else if (Math.abs(gameField.Getter(coordX3, coordY3)) != 0) {

                break;
            }

        }

        while (true) {
            if (++coordX4 > 7) break;
            if (++coordY4 > 7) break;


            if (Math.abs(gameField.Getter(coordX4, coordY4)) == 55 || Math.abs(gameField.Getter(coordX4, coordY4)) == 50) {

                if (whoseFigure(gameField.Getter(coordX4, coordY4), figure)) { //если есть чужой
                    return false;
                } else {
                    coordX4 = 8;
                }
            } else if (Math.abs(gameField.Getter(coordX4, coordY4)) != 0) {

                break;
            }
        }

        //пешка

        if (figure == 64) {//Синие

            if (j - 1 > 0) { //условие верное

                if (i - 1 >= 0) { //левая часть
                    if (gameField.Getter(i - 1, j - 1) == -8) {
                        return false;
                    }
                }


                if (i + 1 < 8) { ////правая часть
                    if (gameField.Getter(i + 1, j - 1) == -8) {
                        return false;

                    }
                }
            }
        }


        if (figure == -64) {//красные
            if (j + 1 < 8) {
                if (i - 1 >= 0) {
                    if (gameField.Getter(i - 1, j + 1) == 8) {
                        return false;
                    }
                }

                if (i + 1 < 8) {
                    if (gameField.Getter(i + 1, j + 1) == 8) {

                        return false;

                    }
                }


            }
        }


        //король


        if (i - 1 >= 0) { // левая часть

            if (j - 1 >= 0 && (gameField.GetStartActionsX() != i - 1 && gameField.GetStartActionsY() != j - 1) && (Math.abs(gameField.Getter(i - 1, j - 1)) == 64)) {

                if (whoseFigure(gameField.Getter(i - 1, j - 1), figure)) { //если есть чужой

                    return false;
                }
            }

            if (j + 1 < 8 && (gameField.GetStartActionsX() != i - 1 && gameField.GetStartActionsY() != j + 1) && (Math.abs(gameField.Getter(i - 1, j + 1)) == 64)) {
                if (whoseFigure(gameField.Getter(i - 1, j + 1), figure)) { //если есть чужой

                    return false;
                }
            }


            if ((gameField.GetStartActionsX() != i - 1 && gameField.GetStartActionsY() != j) && Math.abs(gameField.Getter(i - 1, j)) == 64) {

                if (whoseFigure(gameField.Getter(i - 1, j + 1), figure)) { //если есть чужой
                    return false;
                }
            }
        }

        if (i + 1 < 8) {

            if (j - 1 >= 0 && (gameField.GetStartActionsX() != i + 1 && gameField.GetStartActionsY() != j - 1) && (Math.abs(gameField.Getter(i + 1, j - 1)) == 64)) {
                if (whoseFigure(gameField.Getter(i + 1, j - 1), figure)) { //если есть чужой
                    return false;
                }
            }

            if (j + 1 < 8 && (gameField.GetStartActionsX() != i + 1 && gameField.GetStartActionsY() != j + 1) && (Math.abs(gameField.Getter(i + 1, j + 1)) == 64)) {
                if (whoseFigure(gameField.Getter(i + 1, j + 1), figure)) { //если есть чужой
                    return false;
                }
            }

            if ((gameField.GetStartActionsX() != i + 1 && gameField.GetStartActionsY() != j) && Math.abs(gameField.Getter(i + 1, j)) == 64) {
                if (whoseFigure(gameField.Getter(i + 1, j + 1), figure)) { //если есть чужой
                    return false;
                }
            }

        }

        if (j - 1 >= 0) {
            if ((gameField.GetStartActionsX() != i && gameField.GetStartActionsY() != j - 1) && Math.abs(gameField.Getter(i, j - 1)) == 64) {
                if (whoseFigure(gameField.Getter(i, j - 1), figure)) { //если есть чужой
                    return false;
                }
            }
        }

        if (j + 1 < 8) {

            if ((gameField.GetStartActionsX() != i && gameField.GetStartActionsY() != j + 1) && Math.abs(gameField.Getter(i, j + 1)) == 64) {
                if (whoseFigure(gameField.Getter(i, j + 1), figure)) { //если есть чужой
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkMate(int i, int j, int figure) { //если под атакой true ,если нет false

        //проверка на коня

        boolean checkMate = false; //

        ArrayList<Integer> attacks = new ArrayList<>();

        if (i - 2 >= 0 && j - 1 >= 0 && (Math.abs(gameField.Getter(i - 2, j - 1)) == 25)) { //+ +

            if (whoseFigure(gameField.Getter(i - 2, j - 1), figure)) { //если есть чужой
                gameField.setFigureAttackKing(i - 2, j - 1);
                checkMate = true;
            }
        }
        if (i - 1 >= 0 && j - 2 >= 0 && (Math.abs(gameField.Getter(i - 1, j - 2)) == 25)) {

            if (whoseFigure(gameField.Getter(i - 1, j - 2), figure)) { //если есть чужой
                gameField.setFigureAttackKing(i - 1, j - 2);
                checkMate = true;
            }
        }

        if (i + 1 < 8 && j - 2 >= 0 && (Math.abs(gameField.Getter(i + 1, j - 2)) == 25)) {
            if (whoseFigure(gameField.Getter(i + 1, j - 2), figure)) { //если есть чужой
                gameField.setFigureAttackKing(i + 1, j - 2);
                checkMate = true;
            }
        }

        if (i + 2 < 8 && j - 1 >= 0 && (Math.abs(gameField.Getter(i + 2, j - 1)) == 25)) {

            if (whoseFigure(gameField.Getter(i + 2, j - 1), figure)) { //если есть чужой
                gameField.setFigureAttackKing(i + 2, j - 1);
                checkMate = true;
            }
        }
        ///—————-
        if (i + 2 < 8 && j + 1 < 8 && (Math.abs(gameField.Getter(i + 2, j + 1)) == 25)) {

            if (whoseFigure(gameField.Getter(i + 2, j + 1), figure)) { //если есть чужой
                gameField.setFigureAttackKing(i + 2, j + 1);
                checkMate = true;
            }
        }
        if (i + 1 < 8 && j + 2 < 8 && (Math.abs(gameField.Getter(i + 1, j + 2)) == 25)) {

            if (whoseFigure(gameField.Getter(i + 1, j + 2), figure)) { //если есть чужой
                gameField.setFigureAttackKing(i + 1, j + 2);
                checkMate = true;
            }
        }

        if (i - 1 >= 0 && j + 2 < 8 && (Math.abs(gameField.Getter(i - 1, j + 2)) == 25)) {

            if (whoseFigure(gameField.Getter(i - 1, j + 2), figure)) { //если есть чужой
                gameField.setFigureAttackKing(i - 1, j + 2);
                checkMate = true;
            }
        }
        if (i - 2 >= 0 && j + 1 < 8 && (Math.abs(gameField.Getter(i - 2, j + 1)) == 25)) {

            if (whoseFigure(gameField.Getter(i - 2, j + 1), figure)) { //если есть чужой
                gameField.setFigureAttackKing(i - 2, j + 1);
                checkMate = true;
            }
        }


        int i1;
        for (i1 = i + 1; i1 < 8; i1++) { // по горизонтали
            // i y ; j - cosnt

            if (Math.abs(gameField.Getter(i1, j)) == 55 || Math.abs(gameField.Getter(i1, j)) == 15) {

                if (whoseFigure(gameField.Getter(i1, j), figure)) { //если есть чужой
                    attacks.add(1);
                    checkMate = true;
                    i1 = 9;
                } else {

                    i1 = 9;
                }
            } else if (Math.abs(gameField.Getter(i1, j)) != 0) {

                break;
            }
        }
        for (i1 = i - 1; i1 >= 0; i1--) {  // по горизонтали

            if (Math.abs(gameField.Getter(i1, j)) == 55 || Math.abs(gameField.Getter(i1, j)) == 15) {

                if (whoseFigure(gameField.Getter(i1, j), figure)) { //если есть чужой

                    attacks.add(2);
                    checkMate = true;
                    i1 = -1;
                } else {

                    i1 = -1;
                }
            } else if (Math.abs(gameField.Getter(i1, j)) != 0) {

                break;
            }
        }
        int j1;
        for (j1 = j + 1; j1 < 8; j1++) {  // по вертикали

            if (Math.abs(gameField.Getter(i, j1)) == 55 || Math.abs(gameField.Getter(i, j1)) == 15) {

                if (whoseFigure(gameField.Getter(i, j1), figure)) { //если есть чужой

                    attacks.add(3);
                    checkMate = true;
                    i1 = 8;
                } else {

                    j1 = 8;
                }
            } else if (Math.abs(gameField.Getter(i, j1)) != 0) {

                break;
            }
        }
        for (j1 = j - 1; j1 >= 0; j1--) { // по вертикали

            if (Math.abs(gameField.Getter(i, j1)) == 55 || Math.abs(gameField.Getter(i, j1)) == 15) {

                if (whoseFigure(gameField.Getter(i, j1), figure)) { //если есть чужой
                    attacks.add(4);
                    checkMate = true;
                    i1 = -1;
                } else {
                    j1 = -1;
                }
            } else if (Math.abs(gameField.Getter(i, j1)) != 0) {

                break;
            }
        }


        //по диагонали

        int coordX1 = i;
        int coordY1 = j;

        int coordX2 = i;
        int coordY2 = j;

        int coordX3 = i;
        int coordY3 = j;

        int coordX4 = i;
        int coordY4 = j;

        while (true) { //+
            if (--coordX1 < 0) break;


            if (--coordY1 < 0) break;


            if (Math.abs(gameField.Getter(coordX1, coordY1)) == 55 || Math.abs(gameField.Getter(coordX1, coordY1)) == 50) {

                if (whoseFigure(gameField.Getter(coordX1, coordY1), figure)) { //если есть чужой

                    attacks.add(5);
                    checkMate = true;
                    coordX1 = -1;
                } else {

                    coordX1 = -1;
                }
            } else if (Math.abs(gameField.Getter(coordX1, coordY1)) != 0) {

                break;
            }

        }
        while (true) { //+
            if (++coordX2 > 7) break;

            if (--coordY2 < 0) break;

            if (Math.abs(gameField.Getter(coordX2, coordY2)) == 55 || Math.abs(gameField.Getter(coordX2, coordY2)) == 50) {
                if (whoseFigure(gameField.Getter(coordX2, coordY2), figure)) { //если есть чужой
                    attacks.add(6);
                    checkMate = true;
                    coordX2 = 8;
                } else {

                    coordX2 = 8;
                }
            } else if (Math.abs(gameField.Getter(coordX2, coordY2)) != 0) {

                break;
            }

        }
        System.out.println("третья четверть");
        while (true) {
            if (--coordX3 < 0) break;
            if (++coordY3 > 7) break;


            if (Math.abs(gameField.Getter(coordX3, coordY3)) == 55 || Math.abs(gameField.Getter(coordX3, coordY3)) == 50) {

                if (whoseFigure(gameField.Getter(coordX3, coordY3), figure)) { //если есть чужой

                    attacks.add(7);
                    checkMate = true;
                    coordX3 = -1;
                } else {

                    coordX3 = -1;
                }
            } else if (Math.abs(gameField.Getter(coordX3, coordY3)) != 0) {

                break;
            }

        }

        while (true) {
            if (++coordX4 > 7) break;
            if (++coordY4 > 7) break;


            if (Math.abs(gameField.Getter(coordX4, coordY4)) == 55 || Math.abs(gameField.Getter(coordX4, coordY4)) == 50) {

                if (whoseFigure(gameField.Getter(coordX4, coordY4), figure)) { //если есть чужой
                    attacks.add(8);
                    checkMate = true;
                    coordX4 = 8;
                } else {
                    coordX4 = 8;
                }
            } else if (Math.abs(gameField.Getter(coordX4, coordY4)) != 0) {

                break;
            }
        }

        //пешка

        if (figure == 64) {//Синие

            if (j - 1 > 0) { //условие верное

                if (i - 1 >= 0) { //левая часть
                    if (gameField.Getter(i - 1, j - 1) == -8) {
                        gameField.setFigureAttackKing(i - 1, j - 1);
                        checkMate = true;
                    }
                }


                if (i + 1 < 8) { ////правая часть
                    if (gameField.Getter(i + 1, j - 1) == -8) {
                        gameField.setFigureAttackKing(i + 1, j - 1);
                        checkMate = true;
                    }
                }
            }
        }


        if (figure == -64) {//красные
            if (j + 1 < 8) {
                if (i - 1 >= 0) {
                    if (gameField.Getter(i - 1, j + 1) == 8) {
                        gameField.setFigureAttackKing(i - 1, j + 1);
                        checkMate = true;
                    }
                }

                if (i + 1 < 8) {
                    if (gameField.Getter(i + 1, j + 1) == 8) {
                        gameField.setFigureAttackKing(i - 1, j + 1);
                        checkMate = true;
                    }
                }


            }
        }

        for (int g = 0; g < attacks.size(); g++) {
            figureAttackKing(g, i, j, figure, attacks);
        }
        //король вроде не нужен


        return checkMate;
    }

    public void figureAttackKing(int g, int i, int j, int figure, ArrayList<Integer> attacks) {
        int i1;
        int j1;
        int coordX1 = i;
        int coordY1 = j;

        int coordX2 = i;
        int coordY2 = j;

        int coordX3 = i;
        int coordY3 = j;

        int coordX4 = i;
        int coordY4 = j;
        switch (attacks.get(g)) {
            case 1:
                for (i1 = i + 1; i1 < 8; i1++) { // по горизонтали
                    // i y ; j - cosnt

                    if (Math.abs(gameField.Getter(i1, j)) == 55 || Math.abs(gameField.Getter(i1, j)) == 15) {

                        if (whoseFigure(gameField.Getter(i1, j), figure)) { //если есть чужой
                            gameField.setFigureAttackKing(i1, j);
                            i1 = 9;
                        } else {

                            i1 = 9;
                        }
                    } else if (Math.abs(gameField.Getter(i1, j)) == 0) {
                        gameField.setFigureAttackKing(i1, j);
                        break;
                    } else {
                        break;
                    }
                }
                break;
            case 2:
                for (i1 = i - 1; i1 >= 0; i1--) {  // по горизонтали

                    if (Math.abs(gameField.Getter(i1, j)) == 55 || Math.abs(gameField.Getter(i1, j)) == 15) {

                        if (whoseFigure(gameField.Getter(i1, j), figure)) { //если есть чужой
                            gameField.setFigureAttackKing(i1, j);
                            i1 = -1;
                        } else {

                            i1 = -1;
                        }
                    } else if (Math.abs(gameField.Getter(i1, j)) == 0) {
                        gameField.setFigureAttackKing(i1, j);
                    } else {
                        break;
                    }
                }

                break;
            case 3:
                for (j1 = j + 1; j1 < 8; j1++) {  // по вертикали
                    if (Math.abs(gameField.Getter(i, j1)) == 55 || Math.abs(gameField.Getter(i, j1)) == 15) {
                        if (whoseFigure(gameField.Getter(i, j1), figure)) { //если есть чужой
                            gameField.setFigureAttackKing(i, j1);
                            i1 = 8;
                        } else {
                            j1 = 8;
                        }
                    } else if (Math.abs(gameField.Getter(i, j1)) == 0) {
                        gameField.setFigureAttackKing(i, j1);
                    } else {
                        break;
                    }
                }
                break;
            case 4:
                for (j1 = j - 1; j1 >= 0; j1--) { // по вертикали

                    if (Math.abs(gameField.Getter(i, j1)) == 55 || Math.abs(gameField.Getter(i, j1)) == 15) {

                        if (whoseFigure(gameField.Getter(i, j1), figure)) { //если есть чужой
                            gameField.setFigureAttackKing(i, j1);
                            i1 = -1;
                        } else {
                            j1 = -1;
                        }
                    } else if (Math.abs(gameField.Getter(i, j1)) == 0) {
                        gameField.setFigureAttackKing(i, j1);
                    } else {
                        break;
                    }
                }
                break;
            case 5:
                while (true) { //+
                    if (--coordX1 < 0) break;


                    if (--coordY1 < 0) break;


                    if (Math.abs(gameField.Getter(coordX1, coordY1)) == 55 || Math.abs(gameField.Getter(coordX1, coordY1)) == 50) {

                        if (whoseFigure(gameField.Getter(coordX1, coordY1), figure)) { //если есть чужой

                            gameField.setFigureAttackKing(coordX1, coordY1);
                            coordX1 = -1;
                        } else {

                            coordX1 = -1;
                        }
                    } else if (Math.abs(gameField.Getter(coordX1, coordY1)) == 0) {
                        gameField.setFigureAttackKing(coordX1, coordY1);
                    } else {
                        break;
                    }

                }
                break;
            case 6:
                while (true) { //+
                    if (++coordX2 > 7) break;

                    if (--coordY2 < 0) break;

                    if (Math.abs(gameField.Getter(coordX2, coordY2)) == 55 || Math.abs(gameField.Getter(coordX2, coordY2)) == 50) {
                        if (whoseFigure(gameField.Getter(coordX2, coordY2), figure)) { //если есть чужой
                            gameField.setFigureAttackKing(coordX2, coordY2);
                            coordX2 = 8;
                        } else {

                            coordX2 = 8;
                        }
                    } else if (Math.abs(gameField.Getter(coordX2, coordY2)) == 0) {
                        gameField.setFigureAttackKing(coordX2, coordY2);
                    } else {
                        break;
                    }

                }
                break;
            case 7:
                while (true) {
                    if (--coordX3 < 0) break;
                    if (++coordY3 > 7) break;


                    if (Math.abs(gameField.Getter(coordX3, coordY3)) == 55 || Math.abs(gameField.Getter(coordX3, coordY3)) == 50) {

                        if (whoseFigure(gameField.Getter(coordX3, coordY3), figure)) { //если есть чужой

                            gameField.setFigureAttackKing(coordX3, coordY3);
                            coordX3 = -1;
                        } else {

                            coordX3 = -1;
                        }
                    } else if (Math.abs(gameField.Getter(coordX3, coordY3)) == 0) {
                        gameField.setFigureAttackKing(coordX3, coordY3);
                    } else {
                        break;
                    }

                }
                break;
            case 8:
                while (true) {
                    if (++coordX4 > 7) break;
                    if (++coordY4 > 7) break;

                    if (Math.abs(gameField.Getter(coordX4, coordY4)) == 55 || Math.abs(gameField.Getter(coordX4, coordY4)) == 50) {

                        if (whoseFigure(gameField.Getter(coordX4, coordY4), figure)) { //если есть чужой
                            gameField.setFigureAttackKing(coordX4, coordY4);
                            coordX4 = 8;
                        } else {
                            coordX4 = 8;
                        }
                    } else if (Math.abs(gameField.Getter(coordX4, coordY4)) == 0) {
                        gameField.setFigureAttackKing(coordX4, coordY4);
                    } else {
                        break;
                    }
                }
                break;
            default:
                break;
        }

    }

    public boolean isItNotTheKing(int i, int j, int figure) {
        if (figure > 0) {
            if (gameField.Getter(i, j) == -64) {
                return false;
            }
        } else {
            if (gameField.Getter(i, j) == 64) {
                return false;
            }
        }
        return true;
    }

    public void attackKing(int i, int j, int Figure) {

        Point temp = gameField.GetStartActions();
        gameField.Setter(temp.getX(), temp.getY(), 0);
        gameField.Setter(i, j, Figure);
    }

    public void moveRook(int i, int j, int figure) { //работает
        gameField.StartActions(i, j);
        int i1;
        for (i1 = i + 1; i1 < 8; i1++) { // по горизонтали
            // i y ; j - cosnt
            if ((gameField.Getter(i1, j) == 0)) { //никого нет дальше идем
                gameField.SetActions(i1, j);
            } else if (whoseFigure(gameField.Getter(i1, j), figure) && isItNotTheKing(i1, j, figure)) { //если есть чужой
                gameField.SetActions(i1, j);
                break;
            } else {
                break;//если свой
            }

        }
        for (i1 = i - 1; i1 >= 0; i1--) {  // по горизонтали
            if ((gameField.Getter(i1, j) == 0)) { //никого нет дальше идем
                gameField.SetActions(i1, j);
            } else if (whoseFigure(gameField.Getter(i1, j), figure) && isItNotTheKing(i1, j, figure)) { //если есть чужой
                gameField.SetActions(i1, j);
                break;
            } else {
                break;//если свой
            }
            // i y ; j - cosnt
        }
        int j1;
        for (j1 = j + 1; j1 < 8; j1++) {  // по вертикали
            if ((gameField.Getter(i, j1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i, j1);
            } else if (whoseFigure(gameField.Getter(i, j1), figure) && isItNotTheKing(i, j1, figure)) { //если есть чужой
                gameField.SetActions(i, j1);
                break;
            } else {
                break;//если свой
            }
            // x j ; i - const
        }
        for (j1 = j - 1; j1 >= 0; j1--) { // по вертикали

            if ((gameField.Getter(i, j1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i, j1);
            } else if (whoseFigure(gameField.Getter(i, j1), figure) && isItNotTheKing(i, j1, figure)) { //если есть чужой
                gameField.SetActions(i, j1);
                break;
            } else {
                break;//если свой
            }
            // x j ; i - const

        }
    }

    public void attackRook(int i, int j, int figure) {
        Point temp = gameField.GetStartActions();
        gameField.Setter(temp.getX(), temp.getY(), 0);
        gameField.Setter(i, j, figure);

    }


    public void moveKnight(int i, int j, int figure) {
        gameField.StartActions(i, j);
        if (i - 2 >= 0 && j - 1 >= 0) { //+ +
            if ((gameField.Getter(i - 2, j - 1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i - 2, j - 1);
            } else if (whoseFigure(gameField.Getter(i - 2, j - 1), figure) && isItNotTheKing(i - 2, j - 1, figure)) { //если есть чужой
                gameField.SetActions(i - 2, j - 1);
            }
        }
        if (i - 1 >= 0 && j - 2 >= 0) {
            if ((gameField.Getter(i - 1, j - 2) == 0)) { //никого нет дальше идем
                gameField.SetActions(i - 1, j - 2);
            } else if (whoseFigure(gameField.Getter(i - 1, j - 2), figure) && isItNotTheKing(i - 1, j - 2, figure)) { //если есть чужой
                gameField.SetActions(i - 1, j - 2);
            }
        }

        if (i + 1 < 8 && j - 2 >= 0) {
            if ((gameField.Getter(i + 1, j - 2) == 0)) { //никого нет дальше идем
                gameField.SetActions(i + 1, j - 2);
            } else if (whoseFigure(gameField.Getter(i + 1, j - 2), figure) && isItNotTheKing(i + 1, j - 2, figure)) { //если есть чужой
                gameField.SetActions(i + 1, j - 2);
            }
        }

        if (i + 2 < 8 && j - 1 >= 0) {
            if ((gameField.Getter(i + 2, j - 1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i + 2, j - 1);
            } else if (whoseFigure(gameField.Getter(i + 2, j - 1), figure) && isItNotTheKing(i + 2, j - 1, figure)) { //если есть чужой
                gameField.SetActions(i + 2, j - 1);
            }
        }
        ///—————-
        if (i + 2 < 8 && j + 1 < 8) {
            if ((gameField.Getter(i + 2, j + 1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i + 2, j + 1);
            } else if (whoseFigure(gameField.Getter(i + 2, j + 1), figure) && isItNotTheKing(i + 2, j + 1, figure)) { //если есть чужой
                gameField.SetActions(i + 2, j + 1);
            }
        }
        if (i + 1 < 8 && j + 2 < 8) {
            if ((gameField.Getter(i + 1, j + 2) == 0)) { //никого нет дальше идем
                gameField.SetActions(i + 1, j + 2);
            } else if (whoseFigure(gameField.Getter(i + 1, j + 2), figure) && isItNotTheKing(i + 1, j + 2, figure)) { //если есть чужой
                gameField.SetActions(i + 1, j + 2);
            }
        }

        if (i - 1 >= 0 && j + 2 < 8) {
            if ((gameField.Getter(i - 1, j + 2) == 0)) { //никого нет дальше идем
                gameField.SetActions(i - 1, j + 2);
            } else if (whoseFigure(gameField.Getter(i - 1, j + 2), figure) && isItNotTheKing(i - 1, j + 2, figure)) { //если есть чужой
                gameField.SetActions(i - 1, j + 2);
            }
        }
        if (i - 2 >= 0 && j + 1 < 8) {
            if ((gameField.Getter(i - 2, j + 1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i - 2, j + 1);
            } else if (whoseFigure(gameField.Getter(i - 2, j + 1), figure) && isItNotTheKing(i - 1, j + 2, figure)) { //если есть чужой
                gameField.SetActions(i - 2, j + 1);
            }
        }
    }

    public void attackKnight(int i, int j, int figure) {
        Point temp = gameField.GetStartActions();
        gameField.Setter(temp.getX(), temp.getY(), 0);
        gameField.Setter(i, j, figure);
    }

    public void movePawn(int i, int j, int figure) {
//вычитаем координаты для проверки правильно ли
        gameField.StartActions(i, j);
        if (figure == 8) {//Синие

            if (j - 1 > 0) { //условие верное
                if (gameField.Getter(i, j - 1) == 0) {
                    gameField.SetActions(i, j - 1);
                }
                if (gameField.getPawn(i, figure) == 0) {
                    if (gameField.Getter(i, 5) == 0) {
                        gameField.SetActions(i, 4);
                    }
                    //gameField.SetPawn(i, figure); //отсюда убрать
                }
            }

            if (j - 1 >= 0) { //подправил вродде
                if (i - 1 >= 0) {
                    if (gameField.Getter(i - 1, j - 1) != 0 && whoseFigure(gameField.Getter(i - 1, j - 1), figure) && isItNotTheKing(i - 1, j - 1, figure)) {
                        gameField.SetActions(i - 1, j - 1);
                    }
                }
                if (i + 1 < 8) {
                    if (gameField.Getter(i + 1, j - 1) != 0 && whoseFigure(gameField.Getter(i + 1, j - 1), figure) && isItNotTheKing(i + 1, j - 1, figure)) {
                        gameField.SetActions(i + 1, j - 1);
                    }
                }
            }
        }

        if (figure == -8) {//красные

            if (j + 1 < 8) {
                if (gameField.Getter(i, j + 1) == 0) {
                    gameField.SetActions(i, j + 1);
                }

                if (gameField.getPawn(i, figure) == 0) {
                    if (gameField.Getter(i, 2) == 0) {
                        gameField.SetActions(i, 3);
                    }
                }
            }


            if (j + 1 >= 0) {
                if (i - 1 >= 0) {
                    if (gameField.Getter(i - 1, j + 1) != 0 && whoseFigure(gameField.Getter(i - 1, j + 1), figure) && isItNotTheKing(i - 1, j + 1, figure)) {
                        gameField.SetActions(i - 1, j + 1);
                    }
                }
                if (i + 1 < 8) {
                    if (gameField.Getter(i + 1, j + 1) != 0 && whoseFigure(gameField.Getter(i + 1, j + 1), figure) && isItNotTheKing(i + 1, j + 1, figure)) {
                        gameField.SetActions(i + 1, j + 1);
                    }
                }

            }
        }
        System.out.println("gameField.gameActions.size()=" + gameField.gameActions.size());

    }


    // Массив ходьбы пешек
    public void attackPawn(int i, int j, int figure) {

        Point temp = gameField.GetStartActions();
        gameField.Setter(temp.getX(), temp.getY(), 0);
        if (figure > 0) { //ферзь
            if (j == 0) {
                gameField.Setter(i, j, 55);
                return;
            }
        } else {
            if (j == 7) {
                gameField.Setter(i, j, -55);
                return;
            }
        }
        gameField.SetPawn(i, figure);
        gameField.Setter(i, j, figure);

    }

    public void moveBishop(int i, int j, int figure) { // по идее индексы верные,но надо условия исправить
        gameField.StartActions(i, j);

        int coordX1 = i;
        int coordY1 = j;

        int coordX2 = i;
        int coordY2 = j;

        int coordX3 = i;
        int coordY3 = j;

        int coordX4 = i;
        int coordY4 = j;

        while (true) { //+
            if (--coordX1 < 0) break;


            if (--coordY1 < 0) break;


            if ((gameField.Getter(coordX1, coordY1) == 0)) { //никого нет дальше идем
                gameField.SetActions(coordX1, coordY1);
            } else if (whoseFigure(gameField.Getter(coordX1, coordY1), figure) && isItNotTheKing(coordX1, coordY1, figure)) { //если есть чужой
                gameField.SetActions(coordX1, coordY1);
                break;
            } else {
                break;//если свой
            }

        }

        while (true) { //+
            if (++coordX2 > 7) break;
            if (--coordY2 < 0) break;
            if ((gameField.Getter(coordX2, coordY2) == 0)) { //никого нет дальше идем
                gameField.SetActions(coordX2, coordY2);
            } else if (whoseFigure(gameField.Getter(coordX2, coordY2), figure) && isItNotTheKing(coordX2, coordY2, figure)) { //если есть чужой
                gameField.SetActions(coordX2, coordY2);
                break;
            } else {
                break;//если свой
            }
        }
        while (true) {
            if (--coordX3 < 0) break;
            if (++coordY3 > 7) break;
            if ((gameField.Getter(coordX3, coordY3) == 0)) { //никого нет дальше идем
                gameField.SetActions(coordX3, coordY3);
            } else if (whoseFigure(gameField.Getter(coordX3, coordY3), figure) && isItNotTheKing(coordX3, coordY3, figure)) { //если есть чужой
                gameField.SetActions(coordX3, coordY3);
                break;
            } else {
                break;//если свой
            }
        }

        while (true) {
            if (++coordX4 > 7) break;
            if (++coordY4 > 7) break;
            if ((gameField.Getter(coordX4, coordY4) == 0)) { //никого нет дальше идем
                gameField.SetActions(coordX4, coordY4);
            } else if (whoseFigure(gameField.Getter(coordX4, coordY4), figure) && isItNotTheKing(coordX4, coordY4, figure)) { //если есть чужой
                gameField.SetActions(coordX4, coordY4);
                break;
            } else {
                break;//если свой
            }
        }


    }

    public void attackBishop(int i, int j, int figure) {
        // Тоже самое, только проверят координаты
        Point temp = gameField.GetStartActions();
        gameField.Setter(temp.getX(), temp.getY(), 0);
        gameField.Setter(i, j, figure);

    }

    public void moveQueen(int i, int j, int figure) {
        // Тоже самое, только проверят координаты
        System.out.println("ферзь) x=" + i + "y=" + j);
        gameField.StartActions(i, j);

        int coordX1 = i;
        int coordY1 = j;

        int coordX2 = i;
        int coordY2 = j;

        int coordX3 = i;
        int coordY3 = j;

        int coordX4 = i;
        int coordY4 = j;

        while (true) { //+
            if (--coordX1 < 0) break;


            if (--coordY1 < 0) break;


            if ((gameField.Getter(coordX1, coordY1) == 0)) { //никого нет дальше идем
                gameField.SetActions(coordX1, coordY1);
            } else if (whoseFigure(gameField.Getter(coordX1, coordY1), figure) && isItNotTheKing(coordX1, coordY1, figure)) { //если есть чужой
                gameField.SetActions(coordX1, coordY1);
                break;
            } else {
                break;//если свой
            }

        }

        while (true) { //+
            if (++coordX2 > 7) break;
            if (--coordY2 < 0) break;
            if ((gameField.Getter(coordX2, coordY2) == 0)) { //никого нет дальше идем
                gameField.SetActions(coordX2, coordY2);
            } else if (whoseFigure(gameField.Getter(coordX2, coordY2), figure) && isItNotTheKing(coordX2, coordY2, figure)) { //если есть чужой
                gameField.SetActions(coordX2, coordY2);
                break;
            } else {
                break;//если свой
            }
        }
        while (true) {
            if (--coordX3 < 0) break;
            if (++coordY3 > 7) break;
            if ((gameField.Getter(coordX3, coordY3) == 0)) { //никого нет дальше идем
                gameField.SetActions(coordX3, coordY3);
            } else if (whoseFigure(gameField.Getter(coordX3, coordY3), figure) && isItNotTheKing(coordX3, coordY3, figure)) { //если есть чужой
                gameField.SetActions(coordX3, coordY3);
                break;
            } else {
                break;//если свой
            }
        }

        while (true) {
            if (++coordX4 > 7) break;
            if (++coordY4 > 7) break;
            if ((gameField.Getter(coordX4, coordY4) == 0)) { //никого нет дальше идем
                gameField.SetActions(coordX4, coordY4);
            } else if (whoseFigure(gameField.Getter(coordX4, coordY4), figure) && isItNotTheKing(coordX4, coordY4, figure)) { //если есть чужой
                gameField.SetActions(coordX4, coordY4);
                break;
            } else {
                break;//если свой
            }
        }
        //по горизонтали

        int i1;
        for (i1 = i + 1; i1 < 8; i1++) { // по горизонтали
            // i y ; j - cosnt
            if ((gameField.Getter(i1, j) == 0)) { //никого нет дальше идем
                gameField.SetActions(i1, j);
            } else if (whoseFigure(gameField.Getter(i1, j), figure) && isItNotTheKing(i1, j, figure)) { //если есть чужой
                gameField.SetActions(i1, j);
                break;
            } else {
                break;//если свой
            }

        }
        for (i1 = i - 1; i1 >= 0; i1--) {  // по горизонтали
            if ((gameField.Getter(i1, j) == 0)) { //никого нет дальше идем
                gameField.SetActions(i1, j);
            } else if (whoseFigure(gameField.Getter(i1, j), figure) && isItNotTheKing(i1, j, figure)) { //если есть чужой
                gameField.SetActions(i1, j);
                break;
            } else {
                break;//если свой
            }
            // i y ; j - cosnt
        }
        int j1;
        for (j1 = j + 1; j1 < 8; j1++) {  // по вертикали
            if ((gameField.Getter(i, j1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i, j1);
            } else if (whoseFigure(gameField.Getter(i, j1), figure) && isItNotTheKing(i, j1, figure)) { //если есть чужой
                gameField.SetActions(i, j1);
                break;
            } else {
                break;//если свой
            }
            // x j ; i - const
        }
        for (j1 = j - 1; j1 >= 0; j1--) { // по вертикали

            if ((gameField.Getter(i, j1) == 0)) { //никого нет дальше идем
                gameField.SetActions(i, j1);
            } else if (whoseFigure(gameField.Getter(i, j1), figure) && isItNotTheKing(i, j1, figure)) { //если есть чужой
                gameField.SetActions(i, j1);
                break;
            } else {
                break;//если свой
            }
            // x j ; i - const
        }


    }

    public void attackQueen(int i, int j, int figure) {
        // Тоже самое, только проверят координаты
        Point temp = gameField.GetStartActions();
        gameField.Setter(temp.getX(), temp.getY(), 0);
        gameField.Setter(i, j, figure);


    }


    public boolean whoseFigure(int figure1, int figure2) {
        if (figure1 > 0 && figure2 > 0) return false;

        else if (figure1 < 0 && figure2 < 0) return false;
        else if ((figure1 < 0 && figure2 > 0) || (figure1 > 0 && figure2 < 0)) {
            return true;
        }
        return false;
    }
}
