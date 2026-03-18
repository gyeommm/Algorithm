import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        if(scores.length == 1){
            return 1;
        }
        for(int i = 1; i < scores.length; i++){
            if(scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]){
                return -1;
            }
        }
        
        int answer = 1;
        int sum = scores[0][0] + scores[0][1];
        int max = 0;
        
        Arrays.sort(scores, (a, b) -> {
           if(a[0] == b[0]){
               return a[1] - b[1];
           }
            return b[0] - a[0];
        });
        
        for(int[] now : scores){
            if(now[0] + now[1] <= sum){
                continue;
            }
            
            max = Math.max(max, now[1]);
            if(now[1] >= max){
                answer++;
            }
        }
        
        return answer;
    }
}