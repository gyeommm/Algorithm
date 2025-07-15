import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] arr = new char[h][w];
            Queue<int[]> q = new ArrayDeque<>();
            int[] person = new int[3];

            for(int i = 0; i < h; i++){
                String s = br.readLine();
                for(int j = 0; j < w; j++){
                    arr[i][j] = s.charAt(j);

                    if(arr[i][j] == '*'){
                        q.offer(new int[]{i, j, 0});
                    }else if(arr[i][j] == '@'){
                        person = new int[]{i, j, 1};
                    }
                }
            }
            q.offer(person);

            int count = 0;
            boolean isExited = false;
            while(!q.isEmpty() && !isExited){
                count++;

                int size = q.size();
                while(size-- > 0 && !isExited){
                    int[] now = q.poll();

                    for(int i = 0; i < 4; i++){
                        int[] next = {now[0] + d[i][0], now[1] + d[i][1], now[2]};

                        if(next[0] < 0 || next[0] >= h || next[1] < 0 || next[1] >= w){
                            if(next[2] == 1){
                                sb.append(count).append("\n");
                                isExited = true;
                                break;
                            }

                            continue;
                        }

                        if(arr[next[0]][next[1]] == '#' || arr[next[0]][next[1]] == '*' || (arr[next[0]][next[1]] == '@' && next[2] == 1)){
                            continue;
                        }

                        q.offer(next);
                        if(next[2] == 0){
                            arr[next[0]][next[1]] = '*';
                        }else{
                            arr[next[0]][next[1]] = '@';
                        }
                    }
                }
            }

            if(!isExited){
                sb.append("IMPOSSIBLE\n");
            }
        }

        System.out.print(sb);
    }
}