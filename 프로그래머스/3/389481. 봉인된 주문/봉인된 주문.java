import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        StringBuilder answer = new StringBuilder();
        
        Arrays.sort(bans, (a, b) -> {
            if(a.length() != b.length()){
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        
        for(int i = 0; i < bans.length; i++){
            long ascii = 0;
            
            long mul = 1;
            for(int j = 0; j < bans[i].length(); j++, mul *= 26){
                char now = bans[i].charAt(bans[i].length() - 1 - j);
                ascii += mul * (now - 'a' + 1);
            }
            
            if(ascii > n){
                break;
            }
            n++;
        }
        
        while(n > 0){
            n--;
            answer.append((char)(n % 26 + 'a'));
            n /= 26;
        }
        
        return answer.reverse().toString();
    }
}