// 스택을 사용하지 않은 코드
// 시간 복잡도 O(n^2) 비효율적

class Solution {
    int[] prices;
    int[] answer;
    public int[] solution(int[] prices) {
        this.prices = prices;
        this.answer = new int[prices.length];

        return culc(prices,answer);
    }

    int[] culc(int[] prices, int[] answer){
        int n = prices.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
            if(answer[i] == 0){
                answer[i] = n - 1 - i;
            }
        }
        return answer;
    }
}


// 스택을 사용한 코드
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length -1 - index;
        }
        return answer;
    }
}