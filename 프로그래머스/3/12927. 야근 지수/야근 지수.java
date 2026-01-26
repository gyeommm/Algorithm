import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int size = works.length;
        Integer[] work = new Integer[size];
        for(int i = 0; i < size; i++){
            work[i] = works[i];
        }
        Arrays.sort(work, (a, b) -> b - a);
        
        while(n > 0 && work[0] > 0){
            work[0]--;
            n--;
            for(int i = 1; i < size && n > 0; i++){
                if(work[i] > work[i - 1]){
                    work[i]--;
                    n--;
                }else if(work[i] < work[i - 1]){
                    break;
                }
            }
        }

        for(int i = 0; i < size; i++){
            answer += Math.pow(work[i], 2);
        }
        
        return answer;
    }
}