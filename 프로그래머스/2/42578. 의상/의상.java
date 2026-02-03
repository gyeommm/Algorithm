import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(String[] s : clothes){
            map.put(s[1], map.getOrDefault(s[1], 1) + 1);
        }
        
        for(int c : map.values()){
            answer *= c;
        }
        
        return --answer;
    }
}