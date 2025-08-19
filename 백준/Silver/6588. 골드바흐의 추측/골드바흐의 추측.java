import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i * i <= 1000000; i++){
            if(!isPrime[i]){
                continue;
            }
            
            for(int j = i * i; j <= 1000000; j += i){
                isPrime[j] = false;
            }
        }
        
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            
            boolean isSuccess = false;
            for(int i = 3; i <= n / 2; i += 2){
                if(isPrime[i] && isPrime[n - i]){
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i);
                    isSuccess = true;
                    break;
                }
            }
            
            if(!isSuccess){
                sb.append("Goldbach's conjecture is wrong.");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}