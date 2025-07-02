import java.util.*;
import java.io.*;

class Main{
    static int[] p;
    
    static class Edge{
        int s;
        int e;
        int w;
        
        Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    
    static int find(int v){
        if(p[v] == v){
            return v;
        }
        return p[v] = find(p[v]);
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        p = new int[v + 1];
        for(int i = 1; i <= v; i++){
            p[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {return a.w - b.w;});
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int result = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            
            int sp = find(now.s);
            int ep = find(now.e);
            if(sp == ep){
                continue;
            }
            
            if(sp > ep){
                p[sp] = ep;
            }else{
                p[ep] = sp;
            }
            result += now.w;
        }
        System.out.print(result);
    }
}