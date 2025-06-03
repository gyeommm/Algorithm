import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        boolean[] prime = new boolean[n + 1];
        prime[1] = true;
        for(int i = 2; i * i <= n; i++){
            if(prime[i]){
                continue;
            }
            
            for(int j = i + i; j <= n; j += i){
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