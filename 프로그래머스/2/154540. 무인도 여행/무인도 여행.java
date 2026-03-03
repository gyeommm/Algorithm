import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        int n = maps.length, m = maps[0].length();
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visit[i][j] || maps[i].charAt(j) == 'X'){
                    continue;
                }
                
                q.offer(new int[]{i, j});
                visit[i][j] = true;
                int count = maps[i].charAt(j) - '0';
                while(!q.isEmpty()){
                    int[] now = q.poll();
                    
                    for(int l = 0; l < 4; l++){
                        int[] next = {now[0] + d[l][0], now[1] + d[l][1]};
                        
                        if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m || visit[next[0]][next[1]] || maps[next[0]].charAt(next[1]) == 'X'){
                            continue;
                        }
                        
                        q.offer(next);
                        visit[next[0]][next[1]] = true;
                        count += maps[next[0]].charAt(next[1]) - '0';
                    }
                }
                
                list.add(count);
            }
        }
        
        if(list.isEmpty()){
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}