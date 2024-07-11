import java.util.*;
    
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, 99999};

        int s = 0;
        int count = 0;
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i < gems.length; i++)
            m.put(gems[i], 0);

        for(int e = 0; e < gems.length; e++){
            m.put(gems[e], m.get(gems[e]) + 1);

            if(m.get(gems[e]) == 1)
                count++;

            while(count == m.size()){
                if(e - s < answer[1] - answer[0]){
                    answer[0] = s;
                    answer[1] = e;
                }
                
                m.put(gems[s], m.get(gems[s]) - 1);
                if(m.get(gems[s]) == 0)
                    count--;
                s++;
            }
        }

        answer[0]++;
        answer[1]++;
        return answer;
    }
}