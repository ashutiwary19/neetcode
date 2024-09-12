import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSoduko {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> vMap = new HashMap<>();
        Map<String, Set<Character>> hMap = new HashMap<>();
        Map<String, Set<Character>> gMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                hMap.putIfAbsent(i + "", new HashSet<>());
                vMap.putIfAbsent(j + "", new HashSet<>());
                gMap.putIfAbsent((i / 3) + "" + (j / 3), new HashSet<>());
                if (!hMap.get(i + "").add(board[i][j])
                        || !vMap.get(j + "").add(board[i][j])
                        || !gMap.get((i / 3) + "" + (j / 3)).add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;

    }
}