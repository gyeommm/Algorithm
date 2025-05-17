import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        int kMin = 0, kMax = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            
            if(kMin < arr[i])
                kMin = arr[i];
            kMax += arr[i];
        }
        
        int k = 0;
        while(kMin <= kMax){
            k = (kMin + kMax) / 2;
            
            int rest = k;
            int count = 1;
            boolean isOver = false;
            for(int i = 0; i < n; i++){
                if(rest < arr[i]){
                    rest = k - arr[i];
                    count++;
                    
                    if(count > m){
                        isOver = true;
                        break;
                    }
                }
                else{
                    rest -= arr[i];
                }
            }
            
            if(isOver){
                kMin = k + 1;
            }
            else{
                kMax = k - 1;
            }
        }
        System.out.println(k);
    }
}