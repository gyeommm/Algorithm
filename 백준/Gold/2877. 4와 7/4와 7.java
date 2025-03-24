import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int count = 0;
        int rest = ++k;

        while (rest >= 2) {
            rest /= 2;
            count++;
        }
        k -= (int) Math.pow(2, count--);

        StringBuilder result = new StringBuilder();
        while (count >= 0) {
            int now = (int) Math.pow(2, count--);

            if (k >= now) {
                k -= now;
                result.append("7");
            } else {
                result.append("4");
            }
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
    }
}