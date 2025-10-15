import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        int start = 0;
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];

            start = Math.max(start, arr[i]);
        }
        int end = sum[n];

        while(start <= end){
            int mid = (start + end) / 2;

            int prev = 0;
            int count = 0;
            for(int i = 1; i <= n; i++){
                int value = sum[i] - sum[prev];

                if(value > mid){
                    prev = i - 1;
                    count++;
                }else if(value == mid){
                    prev = i;
                    count++;
                }
            }
            if(prev < n){
                count++;
            }

            if(count > m){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.print(start);
    }
}