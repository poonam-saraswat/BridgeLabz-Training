import java.util.*;

class Result {

    public static String[] crosswordPuzzle(String[] crossword, String words) {
        char[][] grid = new char[10][10];
        for (int i = 0; i < 10; i++) {
            grid[i] = crossword[i].toCharArray();
        }

        String[] wordList = words.split(";");
        solve(grid, wordList, 0);

        String[] result = new String[10];
        for (int i = 0; i < 10; i++) {
            result[i] = new String(grid[i]);
        }
        return result;
    }

    private static boolean solve(char[][] grid, String[] words, int index) {
        if (index == words.length) return true;

        String word = words[index];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (canPlaceHorizontally(grid, word, i, j)) {
                    boolean[] placed = placeHorizontally(grid, word, i, j);
                    if (solve(grid, words, index + 1)) return true;
                    removeHorizontally(grid, word, i, j, placed);
                }
                if (canPlaceVertically(grid, word, i, j)) {
                    boolean[] placed = placeVertically(grid, word, i, j);
                    if (solve(grid, words, index + 1)) return true;
                    removeVertically(grid, word, i, j, placed);
                }
            }
        }
        return false;
    }

    private static boolean canPlaceHorizontally(char[][] grid, String word, int row, int col) {
        if (col + word.length() > 10) return false;
        for (int k = 0; k < word.length(); k++) {
            if (grid[row][col + k] != '-' && grid[row][col + k] != word.charAt(k)) return false;
        }
        return true;
    }

    private static boolean[] placeHorizontally(char[][] grid, String word, int row, int col) {
        boolean[] placed = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (grid[row][col + k] == '-') {
                grid[row][col + k] = word.charAt(k);
                placed[k] = true;
            }
        }
        return placed;
    }

    private static void removeHorizontally(char[][] grid, String word, int row, int col, boolean[] placed) {
        for (int k = 0; k < word.length(); k++) {
            if (placed[k]) grid[row][col + k] = '-';
        }
    }

    private static boolean canPlaceVertically(char[][] grid, String word, int row, int col) {
        if (row + word.length() > 10) return false;
        for (int k = 0; k < word.length(); k++) {
            if (grid[row + k][col] != '-' && grid[row + k][col] != word.charAt(k)) return false;
        }
        return true;
    }

    private static boolean[] placeVertically(char[][] grid, String word, int row, int col) {
        boolean[] placed = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (grid[row + k][col] == '-') {
                grid[row + k][col] = word.charAt(k);
                placed[k] = true;
            }
        }
        return placed;
    }

    private static void removeVertically(char[][] grid, String word, int row, int col, boolean[] placed) {
        for (int k = 0; k < word.length(); k++) {
            if (placed[k]) grid[row + k][col] = '-';
        }
    }
}

public class CrosswordPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] crossword = new String[10];
        for (int i = 0; i < 10; i++) {
            crossword[i] = sc.nextLine();
        }
        String words = sc.nextLine();
        String[] result = Result.crosswordPuzzle(crossword, words);
        for (String row : result) {
            System.out.println(row);
        }
        sc.close();
    }
}
