import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Map<Integer, Integer>> list = new ArrayList<>();    // {이동 가능한 섬, 중량제한}
        for(int i = 0; i <= n; i++){
            list.add(new HashMap<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).put(b, Math.max(list.get(a).getOrDefault(b, 0), c));
            list.get(b).put(a, Math.max(list.get(b).getOrDefault(a, 0), c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // {이동할 섬, 현재까지 최대 중량}
            return b[1] - a[1];
        });
        int[] dp = new int[n + 1];
        pq.offer(new int[]{s, Integer.MAX_VALUE});
        dp[s] = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(now[0] == e){
                break;
            }
            if(dp[now[0]] <= dp[e]){
                continue;
            }

            for(int k : list.get(now[0]).keySet()){
                int v = Math.min(now[1], list.get(now[0]).get(k));

                if(v <= dp[k]){
                    continue;
                }

                pq.offer(new int[]{k, v});
                dp[k] = v;
            }
        }
        System.out.print(dp[e]);
    }
}