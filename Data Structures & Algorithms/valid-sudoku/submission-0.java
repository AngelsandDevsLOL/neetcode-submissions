class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> hSet = new HashSet<>();
            HashSet<Character> hSet2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!hSet.contains(board[i][j])) hSet.add(board[i][j]);
                else if (board[i][j] != '.') return false;

                if (!hSet2.contains(board[j][i])) hSet2.add(board[j][i]);
                else if (board[j][i] != '.') return false;
            }
        }
        HashSet<Character>[][] block = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                block[i][j] = new HashSet<>();
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        if (!block[i][j].contains(board[i * 3 + ii][j * 3 + jj])) block[i][j].add(board[i * 3 + ii][j * 3 + jj]);
                        else if (board[i * 3 + ii][j * 3 + jj] != '.') return false;
                    }
                }
            }
        }
        return true;
    }
}
