import java.util.*;

class Solution {
    List<ArrayDeque<Integer>> s = new ArrayList<>();
    
    public void f(int[] box, int idx, int rest){
        while(!s.get(idx).isEmpty() && rest > 0){
            int peek = s.get(idx).peek();
            
            box[peek] -= rest;
            if(box[peek] > 0){
                rest = 0;
                continue;
            }

            s.get(idx).pop();
            rest = -box[peek];
        }
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        for(int i = 0; i < 2; i++){
            s.add(new ArrayDeque<>());
        }
        
        for(int i = 0; i < n; i++){
            if(deliveries[i] > 0){
                s.get(0).push(i);
            }
            if(pickups[i] > 0){
                s.get(1).push(i);
            }
        }
        
        while(true){
            int[] peek = {-1, -1};
            peek[0] = s.get(0).isEmpty() ? -1 : s.get(0).peek();
            peek[1] = s.get(1).isEmpty() ? -1 : s.get(1).peek();
            
            if(peek[0] == -1 && peek[1] == -1){
                break;
            }
            
            int max = Math.max(peek[0], peek[1]) + 1;
            answer += max * 2;
            
            f(deliveries, 0, cap);
            f(pickups, 1, cap);
        }
        
        return answer;
    }
}