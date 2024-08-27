import java.util.*;
class Solution {
    public int solution(int[] cost) {
        int[] memo = new int[cost.length+1];
        memo[0] = cost[0];
        memo[1] = cost[1];
        for(int i=2; i<cost.length; i++){
            memo[i] = Integer.min(memo[i-2]+cost[i], memo[i-1]+cost[i]);
        }
        return Integer.min(memo[cost.length-1], memo[cost.length-2]);
    }
}