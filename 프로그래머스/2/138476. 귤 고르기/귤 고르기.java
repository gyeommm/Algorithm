import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine){
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int count : map.values()){
            pq.offer(count);
        }
        
        int count = 0;
        while(count < k){
            count += pq.poll();
            answer++;
        }
        
        return answer;
    }
}