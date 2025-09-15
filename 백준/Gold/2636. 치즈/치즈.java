import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static int[][] arr, d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void dfs(int r, int c){
        for(int i = 0; i < 4; i++){
            int nr = r + d[i][0];
            int nc = c + d[i][1];

            if(nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr][nc] == 1 || arr[nr][nc] <= arr[0][0]){
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

        Queue<int[]> cheese = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1){
                    cheese.offer(new int[]{i, j});
                }
            }
        }

        int result = 0;
        while(!cheese.isEmpty()){
            arr[0][0]--;
            dfs(0, 0);

            int size = result = cheese.size();
            while(size-- > 0){
                int[] now = cheese.poll();

                for(int i = 0; i < 4; i++){
                    int nr = now[0] + d[i][0];
                    int nc = now[1] + d[i][1];

                    if(arr[nr][nc] < 0){
                        arr[now[0]][now[1]] = 0;
                        break;
                    }
                }

                if(arr[now[0]][now[1]] == 1){
                    cheese.offer(now);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(-arr[0][0]).append("\n").append(result);
        System.out.print(sb);
    }
}