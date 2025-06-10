import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]>[] list = new ArrayList[n + 1];    // {이동 가능한 섬, 중량제한}
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // {이동할 섬, 현재까지 최대 중량}
            return b[1] - a[1];
        });
        int[] dp = new int[n + 1];
        pq.offer(new int[]{s, 1000000000});
        dp[s] = 1000000000;

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(now[0] == e){
                break;
            }
            if(dp[now[0]] <= dp[e]){
                continue;
            }

            for(int[] next : list[now[0]]){
                next[1] = Math.min(next[1], now[1]);

                if(next[1] <= dp[next[0]]){
                    continue;
                }

                pq.offer(next);
                dp[next[0]] = next[1];
            }
        }
        System.out.print(dp[e]);
    }
}