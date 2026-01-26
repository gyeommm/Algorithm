import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String[] temp = s.toLowerCase().split(" ", -1);
        for(int i = 0; i < temp.length; i++){
            answer.append(" ");
            
            if(temp[i].length() > 0){
                char c = Character.toUpperCase(temp[i].charAt(0));
                answer.append(c).append(temp[i].substring(1));
            }
        }
        
        return answer.toString().substring(1);
    }
}