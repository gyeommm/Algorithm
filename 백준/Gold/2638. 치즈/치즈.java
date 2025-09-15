import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int[][] arr, d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static void dfs(int r, int c){
        for(int i = 0; i < 4; i++){
            int nr = r + d[i][0];
            int nc = c + d[i][1];
            
            if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] <= arr[0][0] || arr[nr][nc] == 1){
                continue;
            }
            
            arr[nr][nc] = arr[0][0];
            dfs(nr, nc);
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        int cheese = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if(arr[i][j] == 1){
                    cheese++;
                }
            }
        }
        
        while(cheese > 0){
            arr[0][0]--;
            dfs(0, 0);
            
            for(int i = 1; i < n - 1; i++){
                for(int j = 1; j < m - 1; j++){
                    if(arr[i][j] != 1){
                        continue;
                    }
                    
                    int count = 0;
                    for(int k = 0; k < 4; k++){
                        int nr = i + d[k][0];
                        int nc = j + d[k][1];
                        
                        if(arr[nr][nc] < 0){
                            count++;
                        }
                    }
                    
                    if(count >= 2){
                        arr[i][j] = 0;
                        cheese--;
                    }
                }
            }
        }
        
        System.out.print(-arr[0][0]);
    }
}