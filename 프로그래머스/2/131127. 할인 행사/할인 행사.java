import java.util.*;

class Solution {
    static Map<String, Integer> rest = new HashMap<>();
    
    static boolean f(){
        for(Integer n : rest.values()){
            if(n > 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < want.length; i++){
            rest.put(want[i], number[i]);
        }
        for(int i = 0; i < 10; i++){
            rest.computeIfPresent(discount[i], (k, v) -> v - 1);
        }
        
        for(int i = 10; i < discount.length; i++){
            answer += f() ? 1 : 0;
            rest.computeIfPresent(discount[i], (k, v) -> v - 1);
            rest.computeIfPresent(discount[i - 10], (k, v) -> v + 1);
        }
        
        return answer + (f() ? 1 : 0);
    }
}