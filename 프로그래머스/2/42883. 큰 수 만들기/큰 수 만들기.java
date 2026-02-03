import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> st = new ArrayDeque<>();

        int size = number.length() - k;
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            while(!st.isEmpty() && st.peek() < c && k-- > 0){
                st.pop();
            }
            st.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString().substring(0, size);
    }
}