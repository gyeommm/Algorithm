import java.util.*;

class Solution {
    static int getDays(String s){
        String[] split = s.split("\\.");
        return Integer.parseInt(split[0]) * 12 * 28 + Integer.parseInt(split[1]) * 28 + Integer.parseInt(split[2]);
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        int todayDays = getDays(today);
        
        Map<String, Integer> termsMap = new HashMap<>();
        for(String s : terms){
            String[] temp = s.split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            int expireDays = getDays(temp[0]);
            expireDays += termsMap.get(temp[1]);
            
            if(todayDays >= expireDays){
                answer.add(i + 1);
            }
        }
        
        return answer;
    }
}