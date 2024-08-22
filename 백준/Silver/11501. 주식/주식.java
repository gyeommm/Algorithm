import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[][] temp = new int[n][2];
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i][0] = Integer.parseInt(st.nextToken());
                temp[i][1] = i;
                arr[i] = temp[i][0];
            }

            Arrays.sort(temp, (a, b) -> {
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }
                return b[0] - a[0];
            });

            long result = 0;
            for (int i = 0, index = 0; i < n && index < n; i++) {
                if(i < temp[index][1] && arr[i] < temp[index][0]) {
                    result += temp[index][0] - arr[i];
                    continue;
                }

                if (arr[i] >= temp[index][0])
                    continue;

                index++;
                i--;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}