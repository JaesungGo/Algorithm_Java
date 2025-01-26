import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numN = Integer.parseInt(st.nextToken());
        int numL = Integer.parseInt(st.nextToken());

        int[] arrInt = new int[numN+1];
        st = new StringTokenizer(br.readLine());
        for(int j=1; j<=numN; j++) {
            arrInt[j] = Integer.parseInt(st.nextToken());
        }

        // 윈도우 역할의 큐 (초기값 null?)
        Deque<Integer> windowQueue = new ArrayDeque<>();

        // 정답을 넣을 배열
        int[] arrAnswer = new int[numN+1];


        /**
         * 큐는 L 보다 크게 값을 가질 수 없다.
         * 1. 만약 i가 L 보다 같거나 작으면, 제거 없이 현재 큐에서 최소 값을 찾음 1. 값 추가 2. 최소 값 찾기
         * 2. 만약 i가 L 보다 크면, 1. 맨 처음 들어온 값을 제거 하고 2. 새로운 값을 추가한 후 3. 최소값을 찾는다.
         * 3. i가 numN이 된다면 종료한다.
         */
        int i = 1;
        while(i <= numN) {
            if(!windowQueue.isEmpty() && windowQueue.getFirst() <= i-numL) {
                windowQueue.removeFirst();
            }

            while(!windowQueue.isEmpty() && arrInt[windowQueue.getLast()] > arrInt[i]) {
                windowQueue.removeLast();
            }

            windowQueue.addLast(i);
            arrAnswer[i] = arrInt[windowQueue.getFirst()];
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(int k=1; k< arrAnswer.length; k++){
            sb.append(arrAnswer[k]).append(" ");
        }
        System.out.println(sb);
    }
}
