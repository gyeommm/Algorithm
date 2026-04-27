import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < prices.length; i++){
            while(!st.isEmpty()){
                if(prices[st.peek()] <= prices[i]){
                    break;
                }
                
                int index = st.poll();
                answer[index] = i - index;
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int index = st.poll();
            answer[index] = prices.length - 1 - index;
        }
        
        return answer;
    }
}