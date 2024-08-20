import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int count = 0;
        int idx = 0;
        int maxEnd = 301;
        int currentEnd = 301;

        while(currentEnd <= 1130){
            boolean flag = false;

            while(idx < n && arr[idx][0] <= currentEnd){
                if(arr[idx][1] > maxEnd){
                    maxEnd = arr[idx][1];
                    flag = true;
                }
                idx++;
            }

            if(flag){

                count++;
                currentEnd = maxEnd;
            }else{
                System.out.println(0);
                return;
            }
        }

        System.out.println(count);
    }
}