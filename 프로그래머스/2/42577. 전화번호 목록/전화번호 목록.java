import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        String prev = "";
        for(String now : phone_book){
            if(prev.length() <= now.length()){
                for(int i = 0; i < prev.length(); i++){
                    if(prev.charAt(i) == now.charAt(i)){
                        answer = false;
                    }else{
                        answer = true;
                        break;
                    }
                }

                if(!answer){
                    break;
                }
            }
            
            prev = now;
        }
        
        return answer;
    }
}