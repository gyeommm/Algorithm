import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine()) + 1;
        StringBuilder sb = new StringBuilder();
        int num;
        while (k > 0) {
            num = k % 2;
            sb.append(num);
            k /= 2;
        }

        StringBuilder result = new StringBuilder();
        String binary = sb.toString();
        for(int i = binary.length() - 2; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result.append(7);
            } else {
                result.append(4);
            }
        }

        bw.write(result.toString());
        br.close();
        bw.flush();
    }
}