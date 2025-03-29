import java.util.*;
import java.io.*;
/**
 * 완주하지 못한 선수의 이름
 * 배열 크기 최대 100,000
 * type[int] : completion.length == participant.length -1
 * 1 <= participant[i].length() <= 20
 * 동명이인 O
 **/

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> hashMap = new HashMap<>();

        for(String partName : participant){
            hashMap.put(partName, hashMap.getOrDefault(partName,0) + 1);
        }

        for(String compName : completion){
            hashMap.put(compName, hashMap.get(compName) - 1 );
        }

        for(Map.Entry<String,Integer> entry : hashMap.entrySet()){
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}