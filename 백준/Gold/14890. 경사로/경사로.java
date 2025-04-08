import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            boolean[] isPlaced = new boolean[n];
            for(int j = 1; j < n; j++){
                if(arr[i][j - 1] < arr[i][j]){
                    if(j - l < 0)
                        break;

                    int expect = arr[i][j] - 1;
                    for(int k = j - 1; k >= j - l; k--){
                        if(arr[i][k] != expect || isPlaced[k]){
                            j = n;
                            break;
                        }
                        isPlaced[k] = true;
                    }
                }
                else if(arr[i][j - 1] > arr[i][j]){
                    if(j + l > n)
                        break;

                    int expect = arr[i][j - 1] - 1;
                    for(int k = j; k < j + l; k++){
                        if(arr[i][j] != expect || isPlaced[k]){
                            j = n;
                            break;
                        }
                        isPlaced[k] = true;
                    }
                }

                if(j == n - 1)
                    result++;
            }
        }

        for(int j = 0; j < n; j++){
            boolean[] isPlaced = new boolean[n];
            for(int i = 1; i < n; i++){
                if(arr[i - 1][j] < arr[i][j]){
                    if(i - l < 0)
                        break;

                    int expect = arr[i][j] - 1;
                    for(int k = i - 1; k >= i - l; k--){
                        if(arr[k][j] != expect || isPlaced[k]){
                            i = n;
                            break;
                        }
                        isPlaced[k] = true;
                    }
                }
                else if(arr[i - 1][j] > arr[i][j]){
                    if(i + l > n)
                        break;

                    int expect = arr[i - 1][j] - 1;
                    for(int k = i; k < i + l; k++){
                        if(arr[i][j] != expect || isPlaced[k]){
                            i = n;
                            break;
                        }
                        isPlaced[k] = true;
                    }
                }

                if(i == n - 1)
                    result++;
            }
        }

        System.out.println(result);
    }
}