import java.util.*;

class Solution {
    static String f(int n){
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.append(n % 2);
            n /= 2;
        }
        
        return sb.toString();
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!"1".equals(s)){
            int c = s.length();
            s = s.replace("0", "");
            answer[1] += c - s.length();
            
            s = f(s.length());
            answer[0]++;
        }
        
        return answer;
    }
}