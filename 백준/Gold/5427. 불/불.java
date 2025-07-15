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
            Queue<int[]> fire = new ArrayDeque<>();
            Queue<int[]> person = new ArrayDeque<>();

            for(int i = 0; i < h; i++){
                String s = br.readLine();
                for(int j = 0; j < w; j++){
                    arr[i][j] = s.charAt(j);

                    if(arr[i][j] == '*'){
                        fire.offer(new int[]{i, j});
                    }else if(arr[i][j] == '@'){
                        person.offer(new int[]{i, j});
                    }
                }
            }

            int count = 0;
            boolean isExited = false;
            while(!person.isEmpty() && !isExited){
                int fSize = fire.size();
                while(fSize-- > 0){
                    int[] now = fire.poll();

                    for(int i = 0; i < 4; i++){
                        int[] next = {now[0] + d[i][0], now[1] + d[i][1]};

                        if(next[0] < 0 || next[0] >= h || next[1] < 0 || next[1] >= w || arr[next[0]][next[1]] == '#' || arr[next[0]][next[1]] == '*'){
                            continue;
                        }

                        fire.offer(next);
                        arr[next[0]][next[1]] = '*';
                    }
                }

                count++;
                int pSize = person.size();
                while(pSize-- > 0){
                    int[] now = person.poll();

                    for(int i = 0; i < 4; i++){
                        int[] next = {now[0] + d[i][0], now[1] + d[i][1]};

                        if(next[0] < 0 || next[0] >= h || next[1] < 0 || next[1] >= w){
                            sb.append(count).append("\n");
                            isExited = true;
                            pSize = 0;
                            break;
                        }

                        if(arr[next[0]][next[1]] == '#' || arr[next[0]][next[1]] == '*' || arr[next[0]][next[1]] == '@'){
                            continue;
                        }

                        person.offer(next);
                        arr[next[0]][next[1]] = '@';
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