import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        int index = 0;
        for(int i = 0; i < days.length; i++){
            days[i] = (100 - progresses[i]) / speeds[i];
            days[i] += (100 - progresses[i]) % speeds[i] == 0 ? 0 : 1;
            
            if(days[index] >= days[i]){
                continue;
            }
            
            answer.add(i - index);
            index = i;
        }
        answer.add(days.length - index);
        
        return answer;
    }
}