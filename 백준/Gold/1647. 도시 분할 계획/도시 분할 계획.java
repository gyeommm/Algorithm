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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        for(int i = 1; i <= n; i++){
            p[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int result = 0;
        int max = 0;
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
            max = Math.max(max, now.w);
        }
        System.out.print(result - max);
    }
}