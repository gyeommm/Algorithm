import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] city = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++){
            city[i][1] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            city[i][0] = Integer.parseInt(st.nextToken());
        }
        
        long fuel = city[0][0];
        long cost = fuel * city[0][1];
        for(int i = 1; i < n - 1; i++){
            fuel = Math.min(fuel, city[i][0]);
            cost += fuel * city[i][1];
        }
        
        System.out.print(cost);
    }
}