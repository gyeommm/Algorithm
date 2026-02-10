import java.util.*;

class Solution {
    static class Node{
        boolean isVisited;
        String s;
        
        Node(String s){
            isVisited = false;
            this.s = s;
        }
    }
    
    static PriorityQueue<String> answer = new PriorityQueue<>();
    static Map<String, List<Node>> map = new HashMap<>();
    static int size = 0;
    
    static void dfs(int depth, String now, String path){
        if (depth == size) {
            answer.offer(path);
            return;
        }
        
        List<Node> list = map.get(now);
        if(list == null){
            return;
        }
        
        for(int i = 0; i < list.size(); i++){
            Node next = list.get(i);
            
            if(!next.isVisited){
                next.isVisited = true;
                
                StringBuilder sb = new StringBuilder(path);
                sb.append("-").append(next.s);
                dfs(depth + 1, next.s, sb.toString());
                
                next.isVisited = false;
            }
        }
    }

    public String[] solution(String[][] tickets){
        size = tickets.length;
        
        for(int i = 0; i < size; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            List<Node> list = map.getOrDefault(from, new ArrayList<>());
            list.add(new Node(to));
            map.put(from, list);
        }
        
        dfs(0, "ICN", "ICN");
        return answer.poll().split("-");
    }
}