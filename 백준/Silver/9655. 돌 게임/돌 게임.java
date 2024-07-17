import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i % 2;
        }

        String result = "CY";
        if(dp[n - 1] == 0)
            result = "SK";

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result);
        bw.close();
    }
}