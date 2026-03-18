import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] ho = scores[0];
        int sum = ho[0] + ho[1];
        int max = 0;
        
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        for(int[] now : scores){
            if(ho[0] < now[0] && ho[1] < now[1]){
                answer = -1;
                break;
            }
            
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