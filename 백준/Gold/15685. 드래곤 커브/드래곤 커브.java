import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] D = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        boolean[][] arr = new boolean[101][101];

        while(n-- > 0){
            int x, y, d, g;
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            ArrayList<int[]> list = new ArrayList<>();
            list.add(new int[]{x, y});
            list.add(new int[]{x + D[d][0], y + D[d][1]});

            while(g-- > 0){
                int[] base = list.get(list.size() - 1);
                for(int i = list.size() - 2; i >= 0; i--){
                    int[] now = list.get(i);
                    int[] gap = {now[0] - base[0], now[1] - base[1]};
                    int[] next = {base[0] + gap[1], base[1] - gap[0]};
                    list.add(next);
                }
            }

            for(int[] temp : list){
                arr[temp[0]][temp[1]] = true;
            }
        }

        int result = 0;
        for(int i = 0; i <= 99; i++){
            for(int j = 0; j <= 99; j++){
                if(!arr[i][j] || !arr[i + 1][j] || !arr[i][j + 1] || !arr[i + 1][j + 1])
                    continue;
                result++;
            }
        }

        System.out.println(result);
    }
}