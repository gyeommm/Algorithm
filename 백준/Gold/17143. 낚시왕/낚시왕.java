import java.util.*;
import java.io.*;

class Main{
    static class Shark{
        int r;
        int c;
        int s;
        int d;

        Shark(int r, int c, int s, int d){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] D = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        Map<Integer, Shark> m = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        int[][] sea = new int[R][C];
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            m.put(z, new Shark(r, c, s, d));
            q.offer(z);
            sea[r][c] = z;
        }

        int result = 0;
        for(int j = 0; j < C; j++){
            for(int i = 0; i < R; i++){
                if(sea[i][j] > 0){
                    result += sea[i][j];
                    m.remove(sea[i][j]);
                    break;
                }
            }

            sea = new int[R][C];

            // 상어 이동
            while(!q.isEmpty()){
                int z = q.poll();

                if(!m.containsKey(z)){
                    continue;
                }

                Shark shark = m.get(z);
                shark.r += D[shark.d][0] * shark.s;
                shark.c += D[shark.d][1] * shark.s;

                while(shark.r < 0 || shark.r >= R){
                    if(shark.r < 0){
                        shark.r = -shark.r;
                    }else{
                        shark.r = (R - 1) - (shark.r - (R - 1));
                    }
                    shark.d = 1 - shark.d;
                }
                while(shark.c < 0 || shark.c >= C){
                    if(shark.c < 0){
                        shark.c = -shark.c;
                    }else{
                        shark.c = (C - 1) - (shark.c - (C - 1));
                    }
                    shark.d = 5 - shark.d;
                }

                if(sea[shark.r][shark.c] > z){
                    m.remove(z);
                    continue;
                }

                m.remove(sea[shark.r][shark.c]);
                m.put(z, shark);
                sea[shark.r][shark.c] = z;
            }

            for(int z : m.keySet()){
                q.offer(z);
            }
        }

        System.out.print(result);
    }
}