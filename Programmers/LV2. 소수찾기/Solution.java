import java.util.*;


class Solution{
    static Set<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        permutation("",numbers);
        int answer = 0;
        for(int num: numberSet){
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    void permutation(String comb, String others){
        if(!comb.equals("")){
            numberSet.add(Integer.parseInt(comb));
        }
        for(int i=0; i<others.length(); i++){
            permutation(comb+others.charAt(i),others.substring(0,i) + others.substring(i+1));
        }
    }

    boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i ==0) return false;
        }
        return true;
    }
}