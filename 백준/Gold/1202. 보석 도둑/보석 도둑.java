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
        
        PriorityQueue<Gem> pq = new PriorityQueue<>((a, b) -> b.v - a.v);
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        TreeMap<Integer, Integer> bag = new TreeMap<>();
        for(int i = 0; i < k; i++){
            int w = Integer.parseInt(br.readLine());
            bag.put(w, bag.getOrDefault(w, 0) + 1);
        }
        
        long result = 0;
        while(!pq.isEmpty() && !bag.isEmpty()){
            Gem gem = pq.poll();
            
            Integer findedBag = bag.ceilingKey(gem.w);
            if(findedBag == null){
                continue;
            }
            
            if(bag.get(findedBag) == 1){
                bag.remove(findedBag);
            }else{
                bag.put(findedBag, bag.get(findedBag) - 1);
            }
            result += gem.v;
        }
        System.out.print(result);
    }
}