import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Set<Integer> s2 = new HashSet<>();
        for(int v : reserve){
            s2.add(v);
        }
        
        Set<Integer> s1 = new TreeSet<>();
        for(int v : lost){
            if(s2.contains(v)){
                s2.remove(v);
                answer++;
            }else{
                s1.add(v);
            }
        }
        
        for(int v : s1){
            if(s2.contains(v - 1)){
                v--;
            }else if(s2.contains(v + 1)){
                v++;
            }else{
                continue;
            }
            
            // s1.remove(v);
            s2.remove(v);
            answer++;
        }
        
        return answer;
    }
}