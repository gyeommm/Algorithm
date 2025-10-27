class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length + 1][m];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = 120;
            }
        }
        dp[0][0] = 0;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + info[i - 1][0]);
                
                int temp = j + info[i - 1][1];
                if(temp < m){
                    dp[i][temp] = Math.min(dp[i][temp], dp[i - 1][j]);
                }
            }
        }
        
        int answer = 120;
        for(int i = 0; i < dp[0].length; i++){
            answer = Math.min(answer, dp[info.length][i]);
        }
        
        return answer < n ? answer : -1;
    }
}