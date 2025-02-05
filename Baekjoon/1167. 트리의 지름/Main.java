import java.io.*;
import java.util.*;

class Main {

    static Map<Integer, List<Node>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numV = Integer.parseInt(st.nextToken());

        for(int i=0; i<numV; i++){
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            List<Node> nodes = new ArrayList<>();
            int value;
            while((value = Integer.parseInt(st.nextToken())) != -1){
                nodes.add(new Node(value , Integer.parseInt(st.nextToken())));
            }
            graph.put(nodeNum,nodes);
        }

        Node farNode = bfs(1);
        Node diamNode = bfs(farNode.node);
        System.out.println(diamNode.dist);
    }

    static Node bfs(int start){
        visited.clear();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start,0));
        visited.put(start,true);

        Node farNode = new Node(start,0);

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            if(currentNode.dist > farNode.dist){
                farNode = currentNode;
            }
            List<Node> nextNodes = graph.get(currentNode.node);
            for (Node nextNode : nextNodes) {
                if(!visited.containsKey(nextNode.node)){
                    queue.add(new Node(nextNode.node, currentNode.dist + nextNode.dist));
                    visited.put(nextNode.node,true);
                }
            }
        }
        return farNode;
    }
}

class Node {
    int node;
    int dist;

    Node(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
