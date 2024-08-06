import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Node{
        int r;
        int c;
        int m;
        Node(int r, int c, int m){
            this.r = r;
            this.c = c;
            this.m = m;
        }
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int solution(String[] maps) {
        int[] firstNode = findStart(maps,'S');
        int[] secondNode = findStart(maps,'L');

        int distance1 = bfs(firstNode[0], firstNode[1], maps, 'L');
        int distance2 = bfs(secondNode[0], secondNode[1], maps, 'E');

        if (distance1 == -1 || distance2 == -1) {
            return -1;
        }

        return distance1 + distance2;
    }

    public static int[] findStart(String[] maps,char o) {
        for(int i=0; i< maps.length; i++){
            for(int j=0; j< maps[0].length(); j++){
                if(maps[i].charAt(j)==o){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No argument");
    }

    public int bfs(int r, int c, String[] maps, char target){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        queue.add(new Node(r,c,0));
        visited[r][c] = true;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            if(maps[curNode.r].charAt(curNode.c) == target ){
                return curNode.m;
            }

            for(int i=0; i<4; i++){
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];

                if (nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[nr].length() &&
                        !visited[nr][nc] && maps[nr].charAt(nc) != 'X') {
                    visited[nr][nc] = true;
                    queue.add(new Node(nr, nc, curNode.m + 1));
                }
            }
        }
        return -1;
    }
}