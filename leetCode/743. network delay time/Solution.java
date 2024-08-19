import java.util.*;
class Edge implements Comparable<Edge> {
    int node, cost;
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Edge(v, w));
        }
        int INF = Integer.MAX_VALUE;
        int[] costs = new int[n+1];
        Arrays.fill(costs, INF);

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));
        costs[k] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.remove();
            if (costs[cur.node] < cur.cost) continue;

            for (Edge next : graph.get(cur.node)) {
                int nextCost = costs[cur.node] + next.cost;
                if (nextCost < costs[next.node]) {
                    pq.add(new Edge(next.node, nextCost));
                    costs[next.node] = nextCost;
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++){
            if (costs[i] == INF) return -1;
            maxTime = Math.max(maxTime, costs[i]);
        }

        return maxTime;
    }
}
