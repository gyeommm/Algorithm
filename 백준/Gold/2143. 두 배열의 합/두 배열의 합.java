import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            aSum[i] = aSum[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] bSum = new int[m + 1];
        for(int i = 1; i <= m; i++){
            bSum[i] = bSum[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        Map<Integer, Integer> aMap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                int key = aSum[i] - aSum[j];
                aMap.put(key, aMap.getOrDefault(key, 0) + 1);
            }
        }
        Map<Integer, Integer> bMap = new HashMap<>();
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < i; j++){
                int key = bSum[i] - bSum[j];
                bMap.put(key, bMap.getOrDefault(key, 0) + 1);
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