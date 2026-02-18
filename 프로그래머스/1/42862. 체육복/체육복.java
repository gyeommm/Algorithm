import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        List<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[31];
        
        for(int v : reserve){
            arr[v] = true;
        }
        
        for(int v : lost){
            if(arr[v]){
                arr[v] = false;
                answer++;
                continue;
            }
            list.add(v);
        }
        
        Collections.sort(list);
        for(int v : list){
            if(arr[v - 1]){
                v--;
            }else if(arr[v + 1]){
                v++;
            }else{
                continue;
            }
            
            arr[v] = false;
            answer++;
        }
        
        return answer;
    }
}