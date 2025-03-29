import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> hs = new HashSet<>();

        for(int num : nums){
            hs.add(num);
        }

        for(int setValue : hs){
            answer++;
        }

        if(answer > nums.length/2){
            return nums.length/2;
        }
        return answer;
    }
}