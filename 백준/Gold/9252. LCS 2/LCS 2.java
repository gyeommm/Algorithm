import java.util.*;
import java.io.*;

class Main{
    static class Point{
        int l;
        int r;
        int c;

        Point(int l, int r, int c){
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        Point[][] dp = new Point[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
            dp[i][0] = new Point(0, 0, 0);
        }
        for(int j = 0; j <= s2.length(); j++){
            dp[0][j] = new Point(0, 0, 0);
        }

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                dp[i][j] = new Point(dp[i - 1][j - 1].l, i - 1, j - 1);

                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j].l++;
                    continue;
                }

                if(dp[i - 1][j].l > dp[i][j].l){
                    dp[i][j] = new Point(dp[i - 1][j].l, i - 1, j);
                }
                if(dp[i][j - 1].l > dp[i][j].l){
                    dp[i][j] = new Point(dp[i][j - 1].l, i, j - 1);
                }
            }
        }

        int r = s1.length();
        int c = s2.length();
        System.out.println(dp[r][c].l);

        StringBuilder sb = new StringBuilder();
        if(dp[r][c].l > 0) {
            while (r != 0 && c != 0) {
                if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    sb.append(s1.charAt(r - 1));
                }

                int tempR = dp[r][c].r;
                int tempC = dp[r][c].c;
                r = tempR;
                c = tempC;
            }
            System.out.print(sb.reverse());
        }
    }
}