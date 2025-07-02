import java.util.*;
import java.io.*;

class Main{
    static class Matrix{
        int r;
        int c;

        Matrix(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Matrix[] arr = new Matrix[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[][] dp = new int[n][n];
        if(n > 1){
            for(int l = 2; l <= n; l++){    // 시작(i) ~ 끝(j)까지의 길이
                for(int i = 0; i < n - l + 1; i++){
                    int j = i + l - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    
                    for(int k = i; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[i].r * arr[k].c * arr[j].c);
                    }
                }
            }
        }
        
        System.out.print(dp[0][n - 1]);
    }
}