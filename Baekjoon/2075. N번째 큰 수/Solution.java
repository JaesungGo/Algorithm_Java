import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < num ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < num ; j++){
                pq.add(Long.parseLong(st.nextToken()));
            }
        }

        Long ans = 0L;
        for(int i = 0 ; i < num ; i++){
            if(i == num-1) ans = pq.poll();
            else pq.poll();
        }
        System.out.println(ans);
    }
}