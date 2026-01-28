import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = maps.length, m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        maps[0][0] = -1;
        
        while(!q.isEmpty()){
            if(maps[n - 1][m - 1] < 0){
                break;
            }
            
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int[] next = {now[0] + d[i][0], now[1] + d[i][1]};
                
                if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m || maps[next[0]][next[1]] <= 0){
                    continue;
                }
                
                q.offer(next);
                maps[next[0]][next[1]] = maps[now[0]][now[1]] - 1;
            }
        }
        
        return -maps[n - 1][m - 1];
    }
}