import java.util.*;
import java.io.*;

public class Main{
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static int[][] graph;
    static int n,m;
    static int maxValue = 0;

    static class Node{
        int r;
        int c;

        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];
        ArrayList<Node> virus = new ArrayList<>();
        ArrayList<int[]> empty = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 2) virus.add(new Node(i, j));
                else if (graph[i][j] == 0) empty.add(new int[]{i, j});
            }
        }

        makeWalls(0,0,empty,virus);
        System.out.println(maxValue);
    }
    static void makeWalls(int count, int start, ArrayList<int[]> empty, ArrayList<Node> virus){
        if( count == 3) {
            int[][] tempGraph = new int[n][m];
            for(int i=0; i<n; i++)
                tempGraph[i] = graph[i].clone();
            for(Node curNode : virus) {
                bfs(tempGraph, curNode.r, curNode.c);
            }
            maxValue = Math.max(maxValue, calcValue(tempGraph));
            return;
        }
        for (int i = start; i < empty.size(); i++) {
            int[] pos = empty.get(i);
            graph[pos[0]][pos[1]] = 1;
            makeWalls(count + 1, i + 1, empty, virus);
            graph[pos[0]][pos[1]] = 0;
        }
    }

    static void bfs(int[][] tempGraph, int r, int c) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(r, c));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];

                if (0 <= nr && nr < n && 0 <= nc && nc < m
                        && tempGraph[nr][nc] == 0) {
                    tempGraph[nr][nc] = 2;
                    queue.add(new Node(nr, nc));
                }
            }
        }
    }

    static int calcValue(int[][] tempGraph){
        int safeValue = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tempGraph[i][j] == 0) safeValue++;
            }
        }
        return safeValue;
    }
}