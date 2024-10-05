package GameOfChessFinal.io1;

import GameOfChessFinal.model.Chess;
import GameOfChessFinal.model.GameField;
import GameOfChessFinal.model.Point;

import java.util.*;
import java.util.Map.Entry;
//import java.util.HashMap;
import java.io.*;

public class PartyFiles {
    GameField gameField;

    public PartyFiles(GameField gameField) {
        this.gameField = gameField;
    }

    public void loadChessGame(String filename) throws FileNotFoundException {
        String str = filename + ".txt";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(str))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder strBuffer = new StringBuilder();
                String[] split = line.split(" ");
                //----------------------
                if (count == 0) {
                    if (!Objects.equals(split[0], "Settings\n")) {
                        gameField.Setter(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[3]));
                    } else {
                        count = 1;
                    }
                } else if (count == 1) {
                    gameField.player = Boolean.parseBoolean(split[0]);
                    count++;
                } else if (count == 2) {
                    gameField.action = Integer.parseInt(split[0]);
                    count++;
                }
                if (count == 3) {
                    for (int i = 0; i < 8; i++) {
                        gameField.pawns1[i] = Integer.parseInt(split[i]);
                    }
                    count++;
                } if (count == 4) {
                    for (int i = 0; i < 8; i++) {
                        gameField.pawns2[i] = Integer.parseInt(split[i]);
                    }
                    count++;
                }
                // добавить шах?
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveChessGame(String filename) { // вроде сделал
        String str = filename + ".txt";
        try (FileWriter writer = new FileWriter(str, false)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (gameField.Getter(i, j) != 0) {
                        System.out.println("i= " + i + " j= " + j);
                        writer.write(i);
                        writer.append(' ');
                        writer.write(j);
                        writer.append(' ');
                        writer.write(gameField.Getter(i, j));
                        writer.append('\n');
                    }
                }
            }
            writer.append("Settings\n");
            boolean player = true;
            writer.write(String.valueOf(player));
            writer.append("\n");
            short action = 0;
            writer.write(action);
            writer.append("\n");
            for (int i = 0; i < 8; i++) {
                writer.write(gameField.pawns1[i]);
                writer.append(' ');
            }
            writer.append("\n");
            for (int i = 0; i < 8; i++) {
                writer.write(gameField.pawns2[i]);
                writer.append(' ');
            }
            writer.append("\n");
            // добавить шах?
            writer.flush();
            System.out.println("File has been written");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
