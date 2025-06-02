import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n + 1];
        for(int i = 1; i <= n; i++){
            a[i] = a[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m + 1];
        for(int i = 1; i <= m; i++){
            b[i] = b[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        Map<Integer, Integer> aMap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                int key = a[i] - a[j];
                aMap.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        Map<Integer, Integer> bMap = new HashMap<>();
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < i; j++){
                int key = b[i] - b[j];
                bMap.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        
        long result = 0;
        for(Map.Entry<Integer, Integer> entry : aMap.entrySet()){
            int k = entry.getKey();
            int v = entry.getValue();
            
            int target = bMap.getOrDefault(t - k, 0);
            result += (long) v * target;
        }
        System.out.print(result);
    }
}