import java.util.*;

class Solution {
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[] board) {
        int answer = -1;
        
        int n = board.length;
        int m = board[0].length();
        int[][] arr = new int[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i].charAt(j) == 'D'){
                    arr[i][j] = -1;
                }else if(board[i].charAt(j) == 'G'){
                    arr[i][j] = -2;
                }else if(board[i].charAt(j) == 'R'){
                    q.offer(new int[]{i, j});
                    arr[i][j] = 1;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int move = arr[now[0]][now[1]] + 1;
            
            for(int i = 0; i < 4; i++){
                int[] next = {now[0], now[1]};
                
                while(true){
                    next[0] += d[i][0];
                    next[1] += d[i][1];

                    if(next[0] < 0 || next[1] < 0 || next[0] >= n || next[1] >= m
                      || arr[next[0]][next[1]] == -1){
                        next[0] -= d[i][0];
                        next[1] -= d[i][1];
                        
                        if(arr[next[0]][next[1]] == -2){
                            return move - 1;
                        }else if(arr[next[0]][next[1]] == 0){
                            arr[next[0]][next[1]] = move;
                            q.offer(next);
                        }
                        
                        break;
                    }
                }
                
            }
        }
        
        return answer;
    }
}