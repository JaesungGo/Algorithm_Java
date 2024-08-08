import java.util.*;

class Solution {
    static Map<Integer, HashSet<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int[] distance;

    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        distance = new int[n+1];
        // 인접 리스트로 변환
        for(int i=1; i<=n; i++){
            graph.put(i,new HashSet<>());
        }

        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        bfs(1);

        return countMaxValueInArray();
    }

    private int countMaxValueInArray() {
        int maxValue = distance[0];
        for(int i=0; i<distance.length; i++){
            if(distance[i] > maxValue){
                maxValue = distance[i];
            }
        }
        int count = 0;
        for(int i : distance){
            if(i == maxValue) count++;
        }
        return count;
    }

    void bfs(int firstNode){
        Queue<Integer> queueNode = new LinkedList<>();
        visited[firstNode] = true;
        queueNode.add(firstNode);
        while(!queueNode.isEmpty()){
            int curNode = queueNode.poll();
            HashSet<Integer> nextNodes = graph.get(curNode);
            for(int nextNode : nextNodes){
                if(!visited[nextNode]){
                    queueNode.add(nextNode);
                    visited[nextNode] = true;
                    distance[nextNode] = distance[curNode]+1;
                }
            }
        }

    }
}