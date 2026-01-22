import java.util.*;

class Solution {
    static int convert(String s){
        String[] temp = s.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
    
    public int solution(String[][] book_time) {
        int answer = 1;
        
        Arrays.sort(book_time, (a, b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(0);
        for(String[] time : book_time){
            int start = convert(time[0]);
            int finish = convert(time[1]) + 10;
            
            int recentFinish = pq.peek();
            if(start < recentFinish){
                answer++;
            }else{
                pq.poll();
            }
            pq.offer(finish);
        }
        
        return answer;
    }
}