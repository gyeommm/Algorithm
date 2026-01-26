import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String lower = s.toLowerCase();
        String[] temp = lower.split(" ", -1);
        for(int i = 0; i < temp.length; i++){
            if(temp[i].length() == 0){
                answer.append(" ");
                continue;
            }
            
            char c = temp[i].charAt(0);
            c = Character.toUpperCase(c);
            
            StringBuilder sb = new StringBuilder();
            sb.append(c).append(temp[i].substring(1));
            
            answer.append(" ").append(sb);
        }
        
        return answer.toString().substring(1);
    }
}