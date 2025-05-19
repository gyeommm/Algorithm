import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        
        int[][] sum = new int[26][s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            int now = s.charAt(i) - 'a';
            
            for(int j = 0; j < 26; j++){
                sum[j][i + 1] = sum[j][i];
            }
            
            sum[now][i + 1]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            int now = a - 'a';
            sb.append(sum[now][r + 1] - sum[now][l]).append("\n");
        }
        
        System.out.println(sb);
    }
}