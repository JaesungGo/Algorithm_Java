import java.util.*;

// wq가 존재하는 동안 계속 반복
// 일차별로 progresses 의 값은 speeds의 값 만큼 늘려준다
// queue의 내용이 100보다 크거나 같아 진다면 wq에서 제거 doneCount ++;
// 그 다음 이어서 바로 다음 queue의 값 확인 100보다 크거나 같아 진다면 wq에서 제거 doneCount ++;
// queue의 값이 100보다 작은 값을 만날 떄 까지 반복한다.
// wq이 완전히 비면 종료

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> wq = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            wq.add(i);
        }

        while(!wq.isEmpty()){
            int doneCount = 0;
            for(int i=0; i< progresses.length; i++){
                progresses[i] += speeds[i];
            }

            while(!wq.isEmpty() && progresses[wq.peek()] >= 100){
                wq.poll();
                doneCount++;
            }

            if(doneCount !=0){
                al.add(doneCount);
            }

        }

        return al.stream()
                .mapToInt(i->i)
                .toArray();
    }
}