import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = numbers.length - 1; i >= 0; i--){
            while(!st.isEmpty()){
                if(numbers[i] < st.peek()){
                    answer[i] = st.peek();
                    break;
                }
                
                st.pop();
            }
            
            st.push(numbers[i]);
        }
        
        return answer;
    }
}