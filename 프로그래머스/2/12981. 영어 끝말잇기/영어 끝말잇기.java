import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i < words.length; i++){
            String prev = words[i - 1];
            String now = words[i];
            answer[1] = i / n + 1;
            
            if(set.contains(now) || prev.charAt(prev.length() - 1) != now.charAt(0)){
                answer[0] = i % n + 1;
                break;
            }
            set.add(now);
        }

        if(answer[0] == 0){
            answer[1] = 0;
        }
        return answer;
    }
}