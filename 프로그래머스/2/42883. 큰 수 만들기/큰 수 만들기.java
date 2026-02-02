import java.util.*;

class Solution {
    static class Node{
        char c;
        int index;
        
        Node(char c, int index){
            this.c = c;
            this.index = index;
        }
    }
    
    public String solution(String number, int k) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> {
            if(a.c == b.c){
                return a.index - b.index;
            }
            return b.c - a.c;
        });
        
        for(int i = 0; i < number.length(); i++){
            pq.offer(new Node(number.charAt(i), i));
        }
        
        int size = number.length() - k;
        Node[] result = new Node[size];
        int pick = 0;
        
        while(pick < size){
            Node now = pq.poll();
            
            int rest = number.length() - (now.index + 1);
            int start = size - rest - 1;
            start = start < 0 ? 0 : start;
            
            for(int i = start; i < size; i++){
                if(result[i] == null){
                    result[i] = now;
                    pick++;
                    break;
                }
                
                if(result[i].index > now.index){
                    break;
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(Node node : result) {
            answer.append(node.c);
        }
        
        return answer.toString();
    }
}