import java.util.*;
import java.io.*;

class Main{
    static class Gem{
        int w;
        int v;
        
        Gem(int w, int v){
            this.w = w;
            this.v = v;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Gem> pq1 = new PriorityQueue<>((a, b) -> a.w - b.w);
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            pq1.offer(new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int[] beg = new int[k];
        for(int i = 0; i < k; i++){
            beg[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(beg);
        
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
        long result = 0;
        for(int i = 0; i < k; i++){
            while(!pq1.isEmpty() && pq1.peek().w <= beg[i]){
                pq2.offer(pq1.poll().v);
            }
            
            if(!pq2.isEmpty()){
                result += pq2.poll();
            }
        }
        System.out.print(result);
    }
}