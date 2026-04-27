import java.util.*;

class Solution {
    static boolean isCorrect(Queue<Character> q){
        Deque<Character> st = new ArrayDeque<>();
        
        while(!q.isEmpty()){
            char c = q.poll();
            
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
                continue;
            }
            
            if(!st.isEmpty() &&
                ((c == ')' && st.peek() == '(') ||
                (c == ']' && st.peek() == '[') ||
                (c == '}' && st.peek() == '{'))){
                st.pop();
                continue;
            }
            
            return false;
        }
        
        return st.isEmpty() ? true : false;
    }
    
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            q.offer(s.charAt(i));
        }
        
        boolean check = false;
        for(int i = 0; i < s.length(); i++){
            if(isCorrect(new ArrayDeque(q))){
                answer++;
                check = true;
            }
            
            q.offer(q.poll());
            if(check){
                q.offer(q.poll());
                i++;
            }
        }
        
        return answer;
    }
}