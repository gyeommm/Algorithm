import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        for(int i = x + 1; i <= y; i++){
            if(i - n > 0){
                dp[i] = dp[i - n];
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2]);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3]);
            }
            
            if(dp[i] == Integer.MAX_VALUE){
                continue;
            }
            dp[i]++;
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}