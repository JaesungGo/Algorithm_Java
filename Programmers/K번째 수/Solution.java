import java.util.*;

class Solution {
    static int[] arrInt;
    public int[] solution(int[] array, int[][] commands) {
        arrInt = array;
        List<Integer> al = new ArrayList<>();
        for(int i=0; i< commands.length; i++){
            int num = foundNum(commands[i]);
            al.add(num);
        }
        return al.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    static int foundNum(int[] command){
        int startIdx = command[0] - 1;
        int endIdx = command[1] - 1;
        int arrLeng = command[2];
        int[] tmp = new int[endIdx - startIdx + 1];

        int j = 0;
        for(int i=startIdx; i<=endIdx; i++){
            tmp[j++] = arrInt[i];
        }
        Arrays.sort(tmp);
        return tmp[arrLeng-1];
    }
}