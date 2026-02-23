import java.util.*;

class Solution{
    public int solution(String s){
        Deque<Character> st = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(st.isEmpty() || st.peek() != s.charAt(i)){
                st.push(s.charAt(i));
                continue;
            }
            st.pop();
        }
        
        return st.isEmpty() ? 1 : 0;
    }
}