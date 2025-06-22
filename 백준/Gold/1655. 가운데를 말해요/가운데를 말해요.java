import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        while(n-- > 0){
            int k = Integer.parseInt(br.readLine());
            if(!pq2.isEmpty() && k < pq2.peek()){
                pq1.offer(k);
                pq2.offer(pq1.poll());
            }
            else{
                pq2.offer(k);
            }
            
            while(pq1.size() < pq2.size() - 2){
                pq1.offer(pq2.poll());
            }
            sb.append(pq2.peek()).append("\n");
        }
        System.out.print(sb);
    }
}