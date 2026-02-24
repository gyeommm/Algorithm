import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i < words.length; i++){
            String prev = words[i - 1];
            String now = words[i];
            
            if(!set.add(now) || prev.charAt(prev.length() - 1) != now.charAt(0)){
                answer = new int[]{i % n + 1, i / n + 1};
                break;
            }
        }
        
        answer[1] = answer[0] == 0 ? 0 : answer[1];
        return answer;
    }
}