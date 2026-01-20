import java.util.*;

class Solution {
    static int currentTime = 0;
    static int index = 0;
    static Deque<Node> stop = new ArrayDeque<>();
    static String[] answer;
    
    static class Node{
        String name;
        int start;
        int playtime;
        
        Node(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    static boolean isFinish(Node now, Node next){
        currentTime += now.playtime;
        if(currentTime > next.start){
            now.playtime = currentTime - next.start;
            stop.push(now);
            currentTime = next.start;
            return false;
        }
        
        answer[index++] = now.name;
        return true;
    }
    
    public String[] solution(String[][] plans) {
        answer = new String[plans.length];
        
        Node[] assignment = new Node[plans.length];
        for(int i = 0; i < plans.length; i++){
            String[] plan = plans[i];
            
            String name = plan[0];
            String[] time = plan[1].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int playtime = Integer.parseInt(plan[2]);
            
            assignment[i] = new Node(name, start, playtime);
        }
        
        Arrays.sort(assignment, (a, b) -> {
            return a.start - b.start;
        });
        
        
        for(int i = 0; i < assignment.length - 1; i++){
            Node now = assignment[i];
            Node next = assignment[i + 1];
            
            currentTime = now.start;
            
            if(!isFinish(now, next)){
                continue;
            }
            
            while(!stop.isEmpty()){
                Node recent = stop.pop();
                
                if(!isFinish(recent, next)){
                    break;
                }
            }
        }
        
        stop.push(assignment[assignment.length - 1]);
        while(!stop.isEmpty()){
            answer[index++] = stop.pop().name;
        }
        
        return answer;
    }
}