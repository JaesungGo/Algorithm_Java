class Solution {
    static boolean[][] visited;
    static char[][] board;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        this.board = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, word)) return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int r, int c, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
                visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (dfs(nr, nc, index + 1, word)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}