//LEETCODE QUESTION 36
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num - '1'; 
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i][n] || cols[j][n] || boxes[boxIndex][n]) {
                        return false; 
                    }

                    rows[i][n] = true;
                    cols[j][n] = true;
                    boxes[boxIndex][n] = true;
                }
            }
        }
        return true; 
    }
}