import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            if (check(places[i])) answer[i] = 1;
        }
        return answer;
    }

    boolean check(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!bfs(r, c, place)) return false;
                }
            }
        }
        return true;
    }

    boolean bfs(int r, int c, String[] place) {
        final int[] dr = {1,-1,0,0};
        final int[] dc = {0,0,-1,1};

        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{ r, c, 0 });
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                int ndist = cur[2]+1;
                if (inRange(nr, nc) && place[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                    if (ndist > 2) continue;
                    if (place[nr].charAt(nc) == 'P') return false;
                    queue.add(new int[]{ nr, nc, ndist });
                    visited[nr][nc] = true;
                }
            }
        }

        return true;
    }

    boolean inRange(int r, int c) {
        return (r >= 0) && (r < 5) && (c >= 0) && (c < 5);
    }
}