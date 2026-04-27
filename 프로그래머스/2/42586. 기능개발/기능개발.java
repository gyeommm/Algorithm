import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        int[] days = new int[progresses.length + 1];
        days[days.length - 1] = 101;
        for(int i = 0; i < progresses.length; i++){
            days[i] = (100 - progresses[i]) / speeds[i];
            days[i] += (100 - progresses[i]) % speeds[i] == 0 ? 0 : 1;
        }
        
        int index = 0;
        for(int i = 1; i < days.length; i++){
            if(days[index] >= days[i]){
                continue;
            }
            
            ans.add(i - index);
            index = i;
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}