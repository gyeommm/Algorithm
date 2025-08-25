import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        int[][] app = new int[n + 1][2];
        int cost = 0;
        for(int i = 1; i <= n; i++){
            app[i][0] = Integer.parseInt(st1.nextToken());
            app[i][1] = Integer.parseInt(st2.nextToken());
            cost += app[i][1];
        }
        
        int[][] dp = new int[n + 1][cost + 1];
        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= cost; j++){
                if(j < app[i][1]){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - app[i][1]] + app[i][0]);
                if(dp[i][j] >= m){
                    result = Math.min(result, j);
                }
            }
        }
        
        System.out.print(result);
    }
}