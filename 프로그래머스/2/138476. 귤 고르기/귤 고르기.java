import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine){
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b - a);
        
        int count = 0;
        for(int i = 0; count < k; i++){
            count += list.get(i);
            answer++;
        }
        
        return answer;
    }
}