import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[words.length];
        q.offer(begin);

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                String s = q.poll();
                if(s.equals(target)){
                    q.clear();
                    answer = level;
                    break;
                }
                
                for(int j = 0; j < words.length; j++){
                    if(isVisited[j]){
                        continue;
                    }
                    
                    String ss = words[j];
                    int count = 0;
                    for(int l = 0; l < ss.length(); l++){
                        if(s.charAt(l) != ss.charAt(l)){
                            if(++count > 1){
                                break;
                            }
                        }
                    }
                    
                    if(count == 1){
                        q.offer(ss);
                        isVisited[j] = true;
                    }
                }
            }
            
            level++;
        }
        
        return answer;
    }
}