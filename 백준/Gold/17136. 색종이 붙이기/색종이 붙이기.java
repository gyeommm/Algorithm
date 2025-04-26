import java.util.*;
import java.io.*;

public class Main{
    static int[][] arr = new int[10][10];
    static int[] paper = new int[6];
    static int min = Integer.MAX_VALUE;

    static void f(int r, int c, int count){
        if (count >= min) {
            return;
        }
        if (c == 10) {
            f(r + 1, 0, count);
            return;
        }
        if (r == 10) {
            min = Math.min(min, count);
            return;
        }
        if (arr[r][c] == 0) {
            f(r, c + 1, count);
            return;
        }

        for(int size = 5; size > 0; size--){
            if(!isPossible(r, c, size) || paper[size] == 5){
                continue;
            }

            for(int i = r; i < r + size; i++){
                for(int j = c; j < c + size; j++){
                    arr[i][j] = 0;
                }
            }
            paper[size]++;
            f(r, c + 1, count + 1);

            for(int i = r; i < r + size; i++){
                for(int j = c; j < c + size; j++){
                    arr[i][j] = 1;
                }
            }
            paper[size]--;
        }
    }

    static boolean isPossible(int r, int c, int size) {
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if (i >= 10 || j >= 10 || arr[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        f(0, 0, 0);
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }
}