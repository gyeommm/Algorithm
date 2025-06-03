import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        boolean[] prime = new boolean[n + 1];
        prime[1] = true;
        for(int i = 2; i * i <= n; i++){
            if(prime[i]){
                continue;
            }
            
            for(int j = i * i; j <= n; j += i){
                prime[j] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = m; i <= n; i++){
            if(prime[i]){
                continue;
            }
            
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}