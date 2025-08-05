import java.util.*;
import java.io.*;

class Main{
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] arr;
    static int[][] visited;
    static int result = 1;
    
    static int dfs(int r, int c){
        if(visited[r][c] > 0){
            return visited[r][c];
        }
        
        visited[r][c] = 1;
        for(int i = 0; i < 4; i++){
            int nr = r + d[i][0];
            int nc = c + d[i][1];
            
            if(arr[nr][nc] <= arr[r][c]){
                continue;
            }
            
            visited[r][c] = Math.max(visited[r][c], dfs(nr, nc) + 1);
        }
        return visited[r][c];
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n + 2][n + 2];
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                result = Math.max(result, dfs(i, j));
            }
        }

        System.out.print(result);
    }
}