import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int h = 0;
        
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            h = citations.length - i;
            
            if(citations[i] >= h){
                break;
            }
            h = 0;
        }
        
        return h;
    }
}