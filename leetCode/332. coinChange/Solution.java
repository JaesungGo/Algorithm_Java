import java.util.*;

class Solution {

    final int LIMIT = Integer.MAX_VALUE;
    public int solution(int[] coins, int amount) {

        // amount를 1로 나누어도 최대 amount개의 memo 요소들만 가질 수 있기 때문
        int[] memo = new int[amount+1];
        Arrays.fill(memo,LIMIT);
        int answer = dp(memo, coins, amount);
        return answer == LIMIT? -1 : answer;
    }

    int dp(int[] memo, int[] coins, int amount){
        int result = LIMIT;
        if(amount == 0) return 0;
        for(int coin : coins){
            // amount - coin이 0이하 일 경우 만들 수 없는 조합
            if(amount - coin >= 0){
                if(memo[amount - coin] == LIMIT){
                    memo[amount-coin] = dp(memo, coins, amount - coin);
                }
                // 만약 amount - coin에 값이 있다면
                result = Math.min(result, memo[amount-coin]);
            }
        }

        // amount
        return (result == LIMIT) ? result : result + 1;
    }
}