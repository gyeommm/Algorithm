import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> list = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n + 1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.get(a).add(b);
            indegree[b]++;
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] != 0){
                continue;
            }
            
            q.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");
            
            for(int v : list.get(now)){
                if(--indegree[v] != 0){
                    continue;
                }
                
                q.offer(v);
            }
        }
        
        System.out.print(sb);
    }
}