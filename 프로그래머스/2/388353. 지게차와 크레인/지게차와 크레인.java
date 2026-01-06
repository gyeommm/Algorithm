import java.util.*;

class Solution {
    static int answer, n, m;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static void dfs(char[][] arr, boolean[][] visited, int r, int c, char target){
        visited[r][c] = true;
        if(arr[r][c] != '-'){
            if(arr[r][c] == target){
                answer--;
                arr[r][c] = '-';
            }
            
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int nr = r + d[i][0];
            int nc = c + d[i][1];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]){
                continue;
            }
            
            dfs(arr, visited, nr, nc, target);
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        answer = n * m;
        
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = storage[i].toCharArray();
        }
        
        for(int k = 0; k < requests.length; k++){
            char target = requests[k].charAt(0);
            if(requests[k].length() == 1){
                boolean[][] visited = new boolean[n][m];
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        if((i > 0 && i < n - 1 && j > 0 && j < m - 1) || visited[i][j]){
                            continue;
                        }
                        
                        dfs(arr, visited, i, j, target);
                    }
                }
            }else{
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        if(arr[i][j] == target){
                            answer--;
                            arr[i][j] = '-';
                        }
                    }
                }
            }
            
        }
        
        return answer;
    }
}