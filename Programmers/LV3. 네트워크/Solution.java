import java.util.*;

class Solution{
    static boolean[] visited;
    static int[][] computers;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n+1];
        this.computers = computers;
        int answer =0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

     void dfs(int calNode){
        visited[calNode] = true;
        for(int i=0; i<computers[0].length; i++){
            if(computers[calNode][i] == 1 && !visited[i] ){
                dfs(i);
            }
        }
    }
}