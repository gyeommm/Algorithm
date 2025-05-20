import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int order = 1;
        
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            g.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            
            g.get(v1).add(v2);
            g.get(v2).add(v1);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n + 1];
        q.offer(r);
        visited[r] = order++;
        
        while(!q.isEmpty()){
            int front = q.poll();
            Collections.sort(g.get(front), Collections.reverseOrder());
            
            for(int i = 0; i < g.get(front).size(); i++){
                int now = g.get(front).get(i);
                
                if(visited[now] != 0){
                    continue;
                }
                
                q.offer(now);
                visited[now] = order++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }
}