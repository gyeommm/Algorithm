import java.util.*;

class Solution {
    static int[] splitToInt(String s){
        String[] split = s.split("\\.");
        int[] splitInt = new int[split.length];
        for(int i = 0; i < splitInt.length; i++){
            splitInt[i] = Integer.parseInt(split[i]);
        }
        return splitInt;
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        int[] todayInt = splitToInt(today);
        
        Map<String, Integer> termsMap = new HashMap<>();
        for(String s : terms){
            String[] temp = s.split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            int[] date = splitToInt(temp[0]);
            
            date[1] += termsMap.get(temp[1]);
            date[0] += (date[1] - 1) / 12;
            date[1] = (date[1] - 1) % 12 + 1;
            
            for(int j = 0; j < todayInt.length; j++){
                if(todayInt[j] < date[j]){
                    break;
                }
                
                if(todayInt[j] > date[j]){
                    answer.add(i + 1);
                    break;
                }else if(j == 2){
                    answer.add(i + 1);
                }
            }
        }
        
        return answer;
    }
}