package yandex.course_1.lesson_2;

import java.util.Scanner;

public class i_Sapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int bombs = scanner.nextInt();

        int[][] bombPositions = new int[bombs][2];
        for (int i = 0; i < bombs; i++) {
            bombPositions[i][0] = scanner.nextInt();
            bombPositions[i][1] = scanner.nextInt();
        }

        int[][] field = best(rows, columns, bombs, bombPositions);

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < rows+1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                String point = field[i][j] == -1 ? "*" : String.valueOf(field[i][j]);
                result.append(point);
                if (j + 1 < columns+1) {
                    result.append(" ");
                }
            }
            if (i + 1 < rows+1) {
                result.append(System.lineSeparator());
            }
        }

        System.out.println(result);
    }

    //использование массивов сдвигов
    public static int[][] best(int rows, int columns, int bombs, int[][] bombPositions) {
        int[][] field = new int[rows + 2][columns + 2];
        if (bombs == 0) {
            return field;
        }

        int[] dCol = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] dRow = {-1, 1, 0, 0, -1, 1, -1, 1};
        for (int i = 0; i < bombs; i++) {
            int xBomb = bombPositions[i][0];
            int yBomb = bombPositions[i][1];
            field[xBomb][yBomb] = -1;
            for (int j = 0; j < 8; j++) {
                if (field[xBomb + dCol[j]][yBomb + dRow[j]] != -1) {
                    field[xBomb + dCol[j]][yBomb + dRow[j]] = field[xBomb + dCol[j]][yBomb + dRow[j]] + 1;
                }
            }
        }

        return field;
    }

    //текущий psvm переделан для варианта best
    public static int[][] getField(int rows, int columns, int bombs, int[][] bombPositions) {
        int[][] field = new int[rows][columns];
        if (bombs == 0) {
            return field;
        }

        for (int i = 0; i < bombs; i++) {
            int x = bombPositions[i][0];
            int y = bombPositions[i][1];
            field[x][y] = -1;
            if (x - 1 > -1) {
                if (field[x - 1][y] != -1) {
                    field[x - 1][y] = field[x - 1][y] + 1;
                }
            }
            if (x + 1 < rows) {
                if (field[x + 1][y] != -1) {
                    field[x + 1][y] = field[x + 1][y] + 1;
                }
            }
            if (y - 1 > -1) {
                if (field[x][y - 1] != -1) {
                    field[x][y - 1] = field[x][y - 1] + 1;
                }
            }
            if (y + 1 < columns) {
                if (field[x][y + 1] != -1) {
                    field[x][y + 1] = field[x][y + 1] + 1;
                }
            }

            if (x - 1 > -1 && y - 1 > -1) {
                if (field[x - 1][y - 1] != -1) {
                    field[x - 1][y - 1] = field[x - 1][y - 1] + 1;
                }
            }
            if (x + 1 < rows && y - 1 > -1) {
                if (field[x + 1][y - 1] != -1) {
                    field[x + 1][y - 1] = field[x + 1][y - 1] + 1;
                }
            }

            if (x - 1 > -1 && y + 1 < columns) {
                if (field[x - 1][y + 1] != -1) {
                    field[x - 1][y + 1] = field[x - 1][y + 1] + 1;
                }
            }
            if (x + 1 < rows && y + 1 < columns) {
                if (field[x + 1][y + 1] != -1) {
                    field[x + 1][y + 1] = field[x + 1][y + 1] + 1;
                }
            }
        }
        return field;
    }
}
