import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], 100001);
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int[] next = {now[0] + d[i][0], now[1] + d[i][1]};

                if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m){
                    continue;
                }

                int count = visited[now[0]][now[1]];
                if(arr[next[0]][next[1]] == 1){
                    count++;
                }

                if(visited[next[0]][next[1]] <= count){
                    continue;
                }

                visited[next[0]][next[1]] = count;
                q.offer(next);
            }
        }

        System.out.print(visited[n - 1][m - 1]);
    }
}