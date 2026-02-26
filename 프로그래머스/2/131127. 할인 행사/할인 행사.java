import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> rest = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            rest.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++){
            rest.computeIfPresent(discount[i], (k, v) -> v - 1);
        }
        
        boolean check = true;
        for(Integer n : rest.values()){
            if(n > 0){
                check = false;
                break;
            }
        }
        answer += check ? 1 : 0;
        
        for(int i = 10; i < discount.length; i++){
            rest.computeIfPresent(discount[i], (k, v) -> v - 1);
            rest.computeIfPresent(discount[i - 10], (k, v) -> v + 1);
            
            check = true;
            for(Integer n : rest.values()){
                if(n > 0){
                    check = false;
                    break;
                }
            }
            answer += check ? 1 : 0;
        }
        
        return answer;
    }
}