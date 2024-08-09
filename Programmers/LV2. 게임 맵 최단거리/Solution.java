import java.util.*;

class Solution{
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;

    class Node{
        int r;
        int c;
        int m;

        public Node(int r, int c, int m){
            this.r = r;
            this.c = c;
            this.m = m;
        }
    }

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        return bfs(maps,0,0);
    }

    int bfs(int[][] maps, int r, int c) {
        Queue<Node> queueNode = new ArrayDeque<>();
        queueNode.add(new Node(r, c, 1));
        visited[r][c] = true;
        while (!queueNode.isEmpty()) {
            Node curNode = queueNode.poll();

            if(curNode.r == maps.length-1 && curNode.c == maps[0].length-1 ) return curNode.m;

            for (int i = 0; i < 4; i++) {
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];

                if (0 <= nr && nr < maps.length && 0 <= nc && nc < maps[0].length
                        && !visited[nr][nc] && maps[nr][nc] == 1) {
                    queueNode.add(new Node(nr, nc, curNode.m + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}