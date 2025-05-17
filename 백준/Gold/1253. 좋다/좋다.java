import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            int s = 0, e = n - 1;
            
            while(true){
                if(s == i)
                    s++;
                else if(e == i)
                    e--;
                
                if(s >= e)
                    break;
                
                int sum = a[s] + a[e];
                if(sum > a[i])
                    e--;
                else if(sum < a[i])
                    s++;
                else{
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}