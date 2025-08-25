import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] app = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            app[i][0] = Integer.parseInt(st.nextToken());
        }
        
        int costSum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            app[i][1] = Integer.parseInt(st.nextToken());
            costSum += app[i][1];
        }
        
        int[] dp = new int[costSum + 1];
        for(int i = 0; i < n; i++){
            for(int j = costSum; j >= app[i][1]; j--){
                dp[j] = Math.max(dp[j], dp[j - app[i][1]] + app[i][0]);
            }
        }
        
        for(int i = 0; i <= dp.length; i++){
            if(dp[i] >= m) {
                System.out.print(i);
                break;
            }
        }
    }
}