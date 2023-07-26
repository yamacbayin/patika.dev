import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private int rowCount;
    private int columnCount;
    int tileCount;
    int mineCount;
    int tilesToReveal;
    private String[][] gameField;
    private String[][] mines;

    private Scanner scanner;


    public MineSweeper(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        scanner = new Scanner(System.in);
        tileCount = rowCount * columnCount;
        mineCount = (rowCount * columnCount) / 4;
        tilesToReveal = tileCount - mineCount;
        setGameField();
        layMines();
        printField(mines);
    }

    public void run() {
        System.out.println("================== M I N E S W E E P E R ==================");
        System.out.println("---------------- Total tiles: " + tileCount + ", Mines: " + mineCount + " ----------------");
        boolean landedOnAMine = false;

        while (!landedOnAMine && tilesToReveal > 0) {

            printField(gameField);
            System.out.println("================= " + "Tiles left to reveal: " + tilesToReveal + " =================");
            int nextX, nextY;

            do {
                System.out.print("Enter the row number to reveal: ");
                nextX = scanner.nextInt();
            } while (nextX < 0 || nextX >= rowCount);
            System.out.println();
            do {
                System.out.print("Enter the column number to reveal: ");
                nextY = scanner.nextInt();
            } while (nextY < 0 || nextY >= columnCount);
            System.out.println();

            landedOnAMine = revealTile(nextX, nextY);

            if (landedOnAMine) {
                printField(gameField);
                System.out.println("Landed on a mine! You lose.");
            }
        }

        if (tilesToReveal == 0) {
            printField(gameField);
            System.out.println("YOU WON!");
        }

        scanner.close();

    }

    private void setGameField() {
        gameField = new String[rowCount][columnCount];
        mines = new String[rowCount][columnCount];

        for (int x = 0; x < rowCount; x++) {
            for (int y = 0; y < columnCount; y++) {
                gameField[x][y] = "-";
            }
        }

        for (int x = 0; x < rowCount; x++) {
            for (int y = 0; y < columnCount; y++) {
                mines[x][y] = "-";
            }
        }
    }

    private void printField(String[][] field) {
        for (String[] array : field) {
            for (String point : array) {
                System.out.print(" " + point + " ");
            }
            System.out.println();
        }
    }

    private void layMines() {
        int minesToLay = mineCount;
        Random random = new Random();

        while (minesToLay > 0) {
            boolean isMineLaid = false;
            while (!isMineLaid) {
                int x = random.nextInt(rowCount);
                int y = random.nextInt(columnCount);
                if (mines[x][y].equals("-")) {
                    mines[x][y] = "*";
                    minesToLay--;
                    isMineLaid = true;
                }

            }
        }
    }

    private boolean revealTile(int x, int y) {
        boolean landedOnAMine = mines[x][y].equals("*");
        boolean alreadyRevealed = !gameField[x][y].equals("-");

        if (alreadyRevealed) {
            return false;
        }

        if (landedOnAMine) {
            gameField[x][y] = "*";
            return true;
        } else {
            int nearbyMineCount = checkNearbyMines(x, y);
            gameField[x][y] = String.valueOf(nearbyMineCount);
            tilesToReveal--;
            return false;
        }
    }

    private int checkNearbyMines(int x, int y) {
        int nearbyMinesCount = 0;

        // check top row
        if (y - 1 >= 0) {
            // top left cell
            if (x - 1 >= 0) {
                nearbyMinesCount += mines[x - 1][y - 1].equals("*") ? 1 : 0;
            }
            // top center cell
            nearbyMinesCount += mines[x][y - 1].equals("*") ? 1 : 0;

            // top right cell
            if (x + 1 < rowCount) {
                nearbyMinesCount += mines[x + 1][y - 1].equals("*") ? 1 : 0;
            }
        }

        // check the same roll
        // check left cell
        if (x - 1 >= 0) {
            nearbyMinesCount += mines[x - 1][y].equals("*") ? 1 : 0;
        }
        // check right cell
        if (x + 1 < rowCount) {
            nearbyMinesCount += mines[x + 1][y].equals("*") ? 1 : 0;
        }

        //check bottom row
        if (y + 1 < columnCount) {
            // bottom left cell
            if (x - 1 >= 0) {
                nearbyMinesCount += mines[x - 1][y + 1].equals("*") ? 1 : 0;
            }
            //bottom center cell
            nearbyMinesCount += mines[x][y + 1].equals("*") ? 1 : 0;

            // bottom right cell
            if (x + 1 < rowCount) {
                nearbyMinesCount += mines[x + 1][y + 1].equals("*") ? 1 : 0;
            }

        }

        return nearbyMinesCount;

    }
}