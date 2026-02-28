import java.util.*;

class Solution {
    static int n, m;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static int[] bfs(int r, int c, char target, String[] maps){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        
        q.offer(new int[]{r, c, 0});
        visit[r][c] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int[] next = {now[0] + d[i][0], now[1] + d[i][1], now[2] + 1};
                
                if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m || maps[next[0]].charAt(next[1]) == 'X' || visit[next[0]][next[1]]){
                    continue;
                }
                if(maps[next[0]].charAt(next[1]) == target){
                    return next;
                }
                
                q.offer(next);
                visit[next[0]][next[1]] = true;
            }
        }
        
        return new int[]{-1, -1, -1};
    }
    
    public int solution(String[] maps) {
        int answer = -1;
        n = maps.length;
        m = maps[0].length();
        
        int[] temp = {0, 0, 0}, temp2 = {0, 0, 0};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) == 'S'){
                    temp = bfs(i, j, 'L', maps);
                    if(temp[2] != -1){
                        temp2 = bfs(temp[0], temp[1], 'E', maps);
                    }
                    i = n;
                    break;
                }
            }
        }
        
        if(temp[2] != -1 && temp2[2] != -1){
            answer = temp[2] + temp2[2];
        }
        return answer;
    }
}