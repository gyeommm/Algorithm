import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = 100000;
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;

            int start = (int) Math.sqrt(i);
            for(int j = start; j > 0; j--){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}