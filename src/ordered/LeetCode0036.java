package ordered;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0036 {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map.containsKey(board[i][j]))
                    return false;
                map.put(board[i][j], 1);
            }
            map.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map.containsKey(board[j][i]))
                    return false;
                map.put(board[j][i], 1);
            }
            map.clear();
        }
        int i = 0, j = 0;
        while (i < 9 && j < 9) {
            for (int t = 0; t < 3; t++){
                for (int k = 0; k < 3; k++) {
                    if (map.containsKey(board[i+t][j+k]))
                        return false;
                    map.put(board[i][j], 1);
                }
            }
            map.clear();
            i += 3;
            j += 3;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
