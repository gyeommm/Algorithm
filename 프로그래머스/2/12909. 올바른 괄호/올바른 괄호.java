import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> st = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            
            if(temp == '('){
                st.push(temp);
                continue;
            }
            
            if(st.isEmpty()){
                answer = false;
                break;
            }
            st.pop();
        }

        return st.isEmpty() ? answer : false;
    }
}