import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> se = new HashSet<>();
        for(int d = 0; d < elements.length; d++){
            int sum = 0;
            for(int i = 0; i <= d; i++){
                sum += elements[i];
            }
            se.add(sum);
            
            for(int i = 1; i % elements.length != 0; i++){
                sum -= elements[i - 1];
                sum += elements[(i + d) % elements.length];
                se.add(sum);
            }
        }
        
        return se.size();
    }
}