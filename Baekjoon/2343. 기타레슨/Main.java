import java.io.*;
import java.util.*;

class Main {
    static int numN,numM;
    static int[] arrInt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numM = Integer.parseInt(st.nextToken());
        numN = Integer.parseInt(st.nextToken());

        arrInt = new int[numM];

        int startIdx = 0;
        int endIdx = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numM; i++){
            arrInt[i] = Integer.parseInt(st.nextToken());
            startIdx = Math.max(startIdx, arrInt[i]);
            endIdx += arrInt[i];
        }

        System.out.println(checkBr(startIdx, endIdx));
    }

    static int checkBr(int startIdx, int endIdx){
        while(startIdx <= endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            int sum = 0;
            int count = 0;

            for(int i = 0; i < numM; i++){
                if(midIdx < sum + arrInt[i]){
                    sum = 0;
                    count++;
                }
                sum += arrInt[i];
            }
            if(sum != 0) count++;

            if(count > numN) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx - 1;
            }
        }
        return startIdx;
    }
}