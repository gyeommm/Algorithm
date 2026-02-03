import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < people.length; i++){
            int count = map.getOrDefault(people[i], 0);
            map.put(people[i], ++count);
        }
        
        while(!map.isEmpty()){
            int rest = limit;
            
            for(int i = 0; i < 2; i++){
                Integer kg = map.floorKey(rest);
                if(kg == null){
                    break;
                }

                rest -= kg;
                map.put(kg, map.get(kg) - 1);
                if(map.get(kg) == 0){
                    map.remove(kg);
                }
            }
            answer++;
        }
        
        return answer;
    }
}