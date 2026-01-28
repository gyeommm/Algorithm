import java.util.*;

class Solution {
    static class Node{
        boolean isVisited;
        List<String> list;
        
        Node(){
            isVisited = false;
            list = new ArrayList<>();
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Map<String, Node> m = new HashMap<>();
        m.put(begin, new Node());
        
        boolean isExist = false;
        for(String s : words){
            m.put(s, new Node());
            if(s.equals(target)){
                isExist = true;
            }
            
            int count = 0;
            for(int l = 0; l < begin.length(); l++){
                if(begin.charAt(l) != s.charAt(l)){
                    count++;
                }
            }

            if(count == 1){
                m.get(begin).list.add(s);
                m.get(s).list.add(begin);
            }
        }
        
        if(!isExist){
            return 0;
        }
        
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            for(int j = i + 1; j < words.length; j++){
                String ss = words[j];
                
                int count = 0;
                for(int l = 0; l < s.length(); l++){
                    if(s.charAt(l) != ss.charAt(l)){
                        count++;
                    }
                }
                
                if(count == 1){
                    m.get(s).list.add(ss);
                    m.get(ss).list.add(s);
                }
            }
        }
        
        Queue<String> q = new ArrayDeque<>();
        q.offer(begin);
        m.get(begin).isVisited = true;

        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                String s = q.poll();
                if(s.equals(target)){
                    q.clear();
                    break;
                }
                
                Node now = m.get(s);
                for(String ss : now.list){
                    Node next = m.get(ss);
                    if(next.isVisited){
                        continue;
                    }

                    q.offer(ss);
                    next.isVisited = true;
                }
            }
            
            answer++;
        }
        
        return answer - 1;
    }
}