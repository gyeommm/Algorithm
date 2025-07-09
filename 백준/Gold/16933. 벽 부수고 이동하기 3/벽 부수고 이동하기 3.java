import java.util.*;
import java.io.*;

class Main{
    static class Node{
        int r;
        int c;
        int k;
        boolean isDay;
        int count;

        Node(int r, int c, int k, boolean isDay, int count){
            this.r = r;
            this.c = c;
            this.k = k;
            this.isDay = isDay;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception{
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        int result = 1000000;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = -1;
            }
        }
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, k, true, 1));
        visited[0][0] = k;

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.r == n - 1 && now.c == m - 1){
                result = Math.min(result, now.count);
                continue;
            }

            for(int i = 0; i < 4; i++){
                Node next = new Node(now.r + d[i][0], now.c + d[i][1], now.k, !now.isDay, now.count + 1);

                if(next.r < 0 || next.r >= n || next.c < 0 || next.c >= m || visited[next.r][next.c] >= now.k){
                    continue;
                }

                if(arr[next.r][next.c] == 1){
                    if(now.k - 1 <= visited[next.r][next.c]){
                        continue;
                    }

                    if(!now.isDay){
                        q.offer(new Node(now.r, now.c, now.k, !now.isDay, now.count + 1));
                        continue;
                    }

                    next.k--;
                }

                q.offer(next);
                visited[next.r][next.c] = next.k;
            }
        }

        if(result == 1000000){
            result = -1;
        }
        System.out.print(result);
    }
}