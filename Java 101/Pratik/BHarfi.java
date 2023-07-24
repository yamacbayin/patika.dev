public class BHarfi {

    public static void main(String[] args) {
        String[][] letter = new String[10][6];

        for (int r = 0; r < letter.length; r++) {
            for (int c = 0; c < letter[r].length; c++) {
                if (r == 0
                        || r == 1
                        || r == 4
                        || r == 5
                        || r == 8
                        || r == 9) {
                    letter[r][c] = " * ";
                } else if (c == 0
                        || c == 1
                        || c == 4
                        || c == 5) {
                    letter[r][c] = " * ";
                } else {
                    letter[r][c] = "   ";
                }
            }
        }

        for (String[] row : letter) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

}