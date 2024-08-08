import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arrChar = s.toCharArray();

        for(int j=0; j<s.length(); j++) {
            char c = arrChar[0];
            for (int i = 0; i < s.length() - 1; i++) {
                arrChar[i] = arrChar[i + 1];
            }
            arrChar[s.length() - 1] = c;

            String s1 = new String(arrChar);
            if (useStack(s1)) {
                answer++;
            }
        }
        return answer;
    }

    boolean useStack(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }else if( c == ')' && stack.peek() == '(' ){
                stack.pop();
            }else if( c== '}' && stack.peek() == '{'){
                stack.pop();
            }else if( c== ']' && stack.peek() == '['){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}