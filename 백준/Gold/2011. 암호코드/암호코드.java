import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = "0" + s;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9) {
                bw.write('0');
                bw.close();
                return;
            }
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int temp = Integer.parseInt(s.substring(i - 1, i + 1));

            if (temp == 10 || temp == 20) {
                dp[i] += dp[i - 2];
                continue;
            }

            if (temp < 10 || temp > 26) {
                if (temp % 10 == 0) {
                    bw.write('0');
                    bw.close();
                    return;
                }
                dp[i] += dp[i - 1];
            }
            else {
                dp[i] += dp[i - 2] + dp[i - 1];
            }

            dp[i] %= 1000000;
        }

        bw.write(String.valueOf(dp[dp.length - 1]));
        bw.close();
    }
}