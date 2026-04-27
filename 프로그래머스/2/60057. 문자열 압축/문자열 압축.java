import java.util.*;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        
        for(int i = 1; i <= length; i++){
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < s.length(); j += i){
                temp.add(s.substring(j, Math.min(j + i, s.length())));
            }
            
            int count = 0, duplicate = 1;
            for(int j = 1; j < temp.size(); j++){
                if(temp.get(j - 1).equals(temp.get(j))){
                    duplicate++;
                }else{
                    count += i;
                    if(duplicate > 1){
                        count += String.valueOf(duplicate).length();
                        duplicate = 1;
                    }
                }
            }
            count += temp.get(temp.size() - 1).length();
            if(duplicate > 1){
                count += String.valueOf(duplicate).length();
            }
            
            answer = Math.min(answer, count);
        }
        
        return answer;
    }
}