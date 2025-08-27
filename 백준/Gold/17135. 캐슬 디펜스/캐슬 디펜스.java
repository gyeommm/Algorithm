import java.util.*;
import java.io.*;

class Main{
    static int distance(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> enemy = new ArrayDeque<>();
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                if(arr[i][j] == 1){
                    enemy.offer(new int[]{i, j});
                }
            }
        }

        int[][] archer = {{n, -1}, {n, -1}, {n, -1}};
        int result = 0;
        for(int i = 0; i < m; i++){
            archer[0][1] = i;
            for(int j = i + 1; j < m; j++){
                archer[1][1] = j;
                for(int k = j + 1; k < m; k++){
                    archer[2][1] = k;
                    int count = 0;

                    Queue<int[]> copy = new ArrayDeque<>();
                    for (int[] e : enemy) {
                        copy.offer(e.clone());
                    }

                    while(!copy.isEmpty()){
                        int[][] death = {{-1, -1, 225}, {-1, -1, 225}, {-1, -1, 225}};
                        int size = copy.size();

                        for(int s = 0; s < size; s++){
                            int[] e = copy.poll();

                            for(int l = 0; l < 3; l++){
                                int dist = distance(archer[l], e);
                                if(dist > d || dist >= death[l][2]){
                                    continue;
                                }

                                death[l][0] = e[0];
                                death[l][1] = e[1];
                                death[l][2] = dist;
                            }

                            copy.offer(e);
                        }

                        for(int s = 0; s < size; s++){
                            int[] e = copy.poll();

                            boolean isDead = false;
                            for(int l = 0; l < 3; l++) {
                                if(e[0] == death[l][0] && e[1] == death[l][1]){
                                    isDead = true;
                                    count++;
                                    break;
                                }
                            }

                            if(isDead || e[0] + 1 >= n){
                                continue;
                            }
                            copy.offer(new int[]{e[0] + 1, e[1]});
                        }

                        result = Math.max(result, count);
                    }
                }
            }
        }

        System.out.print(result);
    }
}