import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String type = clothes[i][1];
            
            int c = map.getOrDefault(type, 1);
            map.put(type, ++c);
        }
        
        for(int c : map.values()){
            answer *= c;
        }
        
        return --answer;
    }
}