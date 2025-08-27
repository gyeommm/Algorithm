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

        List<int[]> enemy = new ArrayList<>();
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                if(arr[i][j] == 1){
                    enemy.add(new int[]{i, j});
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

                    List<int[]> copy = new ArrayList<>();
                    for (int[] e : enemy) {
                        copy.add(e.clone());
                    }

                    int count = 0;
                    boolean check = true;
                    while(check){
                        check = false;
                        int[][] target = {{225, -1}, {225, -1}, {225, -1}};

                        for(int s = 0; s < copy.size(); s++){
                            int[] e = copy.get(s);
                            if(e[0] >= n){
                                continue;
                            }

                            check = true;
                            for(int l = 0; l < 3; l++){
                                int dist = distance(archer[l], e);
                                if(dist > d || dist >= target[l][0]){
                                    continue;
                                }

                                target[l][0] = dist;
                                target[l][1] = s;
                            }

                            e[0]++;
                        }

                        for(int l = 0; l < 3; l++){
                            int s = target[l][1];
                            if(s == -1 || copy.get(s)[0] == n + 1){
                                continue;
                            }

                            copy.get(s)[0] = n + 1;
                            count++;
                        }
                    }

                    result = Math.max(result, count);
                }
            }
        }

        System.out.print(result);
    }
}