import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        int[][] d = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int gr = Integer.parseInt(st.nextToken());
            int gc = Integer.parseInt(st.nextToken());
            
            int[][] visited = new int[n][n];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{r, c});
            visited[r][c] = 1;
            
            boolean check = true;
            while(check && !q.isEmpty()){
                int[] now = q.poll();
                
                for(int i = 0; i < 8; i++){
                    int[] next = {now[0] + d[i][0], now[1] + d[i][1]};
                    
                    if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n || visited[next[0]][next[1]] > 0){
                        continue;
                    }
                    
                    visited[next[0]][next[1]] = visited[now[0]][now[1]] + 1;
                    if(next[0] == gr && next[1] == gc){
                        check = false;
                        break;
                    }
                    
                    q.offer(next);
                }
            }
            sb.append(visited[gr][gc] - 1).append("\n");
        }
        
        System.out.print(sb);
    }
}