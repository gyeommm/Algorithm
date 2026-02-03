import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < prices.length; i++){
            int now = prices[i];
            
            while(!st.isEmpty() && prices[st.peek()] > prices[i]){
                int index = st.pop();
                answer[index] = i - index;
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int index = st.pop();
            answer[index] = prices.length - 1 - index;
        }
        
        return answer;
    }
}