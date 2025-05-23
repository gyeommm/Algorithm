import java.util.*;
import java.io.*;

public class Main{
    static char[][] arr;
    static int[][] p = {{0, 2}, {1, 1}, {1, 3}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}};

    static void divide(int sr, int er, int sc, int ec){
        if(er - sr < 3){
            for(int i = 0; i < p.length; i++)
                arr[sr + p[i][0]][sc + p[i][1]] = '*';
            return;
        }

        divide(sr, sr + (er - sr) / 2, sc + (ec - sc) / 4 + 1, ec - ((ec - sc) / 4 + 1));
        divide(sr + (er - sr) / 2 + 1, er, sc, sc + (ec - sc) / 2 - 1);
        divide(sr + (er - sr) / 2 + 1, er, sc + (ec - sc) / 2 + 1, ec);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n * 2 - 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(arr[i], ' ');

        divide(0, arr.length - 1, 0, arr[0].length - 1);

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}