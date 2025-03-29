import java.util.*;
class Solution {
    public int solution(int[][] sizes) {

        int maxFirst = 0;
        int maxSecond = 0;

        for(int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
            if(maxFirst < sizes[i][0]) maxFirst = sizes[i][0];
            if(maxSecond < sizes[i][1]) maxSecond = sizes[i][1];
        }

        return maxFirst * maxSecond;

    }
}