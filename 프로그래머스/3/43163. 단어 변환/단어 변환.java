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
    
    static class Node2{
        String s;
        int count;
        
        Node2(String s, int count){
            this.s = s;
            this.count = count;
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
        
        Queue<Node2> q = new ArrayDeque<>();
        q.offer(new Node2(begin, 0));
        m.get(begin).isVisited = true;

        while(!q.isEmpty()){
            Node2 temp = q.poll();
            if(temp.s.equals(target)){
                answer = temp.count;
                break;
            }
            
            Node now = m.get(temp.s);
            
            for(String s : now.list){
                Node next = m.get(s);
                if(next.isVisited){
                    continue;
                }
                
                q.offer(new Node2(s, temp.count + 1));
                next.isVisited = true;
            }
        }
        
        return answer;
    }
}