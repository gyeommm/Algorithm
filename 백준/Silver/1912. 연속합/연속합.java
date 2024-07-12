import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        arr[0] = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            dp[i][0] = arr[i] + Math.max(dp[i - 1][0], 0);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(Math.max(dp[n - 1][0], dp[n - 1][1])));
        bw.close();
    }
}