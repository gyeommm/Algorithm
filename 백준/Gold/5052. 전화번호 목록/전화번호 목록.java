import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            String[] arr = new String[n];
            for(int i = 0; i < n; i++){
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);

            int i = 0;
            for(; i < n - 1; i++){
                if(arr[i + 1].startsWith(arr[i])){
                    sb.append("NO\n");
                    break;
                }
            }
            if(i == n - 1){
                sb.append("YES\n");
            }
        }
        System.out.print(sb);
    }
}