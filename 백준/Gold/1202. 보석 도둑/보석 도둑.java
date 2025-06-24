import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        
        TreeMap<Integer, Integer> bag = new TreeMap<>();
        for(int i = 0; i < k; i++){
            int w = Integer.parseInt(br.readLine());
            bag.put(w, bag.getOrDefault(w, 0) + 1);
        }
        
        long result = 0;
        while(!pq.isEmpty() && !bag.isEmpty()){
            int[] gem = pq.poll();
            
            Integer findedBag = bag.ceilingKey(gem[0]);
            if(findedBag == null){
                continue;
            }
            
            if(bag.get(findedBag) == 1){
                bag.remove(findedBag);
            }else{
                bag.put(findedBag, bag.get(findedBag) - 1);
            }
            result += gem[1];
        }
        System.out.print(result);
    }
}