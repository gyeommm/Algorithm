import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] board;
    static int result = 0;
    
    static void f(int count){
        if(count == 5){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    result = Math.max(result, board[i][j]);
                }
            }
            return;
        }
        
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++){
            copy[i] = board[i].clone();
        }
        
        for(int i = 0; i < 4; i++){
            if(i == 0){        // 아래
                for(int c = 0; c < n; c++){
                    int target = n - 1;
                    for(int r = n - 2; r >= 0; r--){
                        if(board[r][c] == 0){
                            continue;
                        }
                        
                        int temp = board[r][c];
                        board[r][c] = 0;
                        if(board[target][c] == 0){
                            board[target][c] = temp;
                        }else{
                            if(board[target][c] == temp){
                                board[target--][c] *= 2;
                            }else{
                                board[--target][c] = temp;
                            }
                        }
                    }
                }
            }else if(i == 1){  // 위
                for(int c = 0; c < n; c++){
                    int target = 0;
                    for(int r = 1; r < n; r++){
                        if(board[r][c] == 0){
                            continue;
                        }
                        
                        int temp = board[r][c];
                        board[r][c] = 0;
                        if(board[target][c] == 0){
                            board[target][c] = temp;
                        }else{
                            if(board[target][c] == temp){
                                board[target++][c] *= 2;
                            }else{
                                board[++target][c] = temp;
                            }
                        }
                    }
                }
            }else if(i == 2){  // 우
                for(int r = 0; r < n; r++){
                    int target = n - 1;
                    for(int c = n - 2; c >= 0; c--){
                        if(board[r][c] == 0){
                            continue;
                        }
                        
                        int temp = board[r][c];
                        board[r][c] = 0;
                        if(board[r][target] == 0){
                            board[r][target] = temp;
                        }else{
                            if(board[r][target] == temp){
                                board[r][target--] *= 2;
                            }else{
                                board[r][--target] = temp;
                            }
                        }
                    }
                }
            }else{             // 좌
                for(int r = 0; r < n; r++){
                    int target = 0;
                    for(int c = 1; c < n; c++){
                        if(board[r][c] == 0){
                            continue;
                        }
                        
                        int temp = board[r][c];
                        board[r][c] = 0;
                        if(board[r][target] == 0){
                            board[r][target] = temp;
                        }else{
                            if(board[r][target] == temp){
                                board[r][target++] *= 2;
                            }else{
                                board[r][++target] = temp;
                            }
                        }
                    }
                }
            }
            
            f(count + 1);
            for(int j = 0; j < n; j++){    // 이동 복구
                board[j] = copy[j].clone();
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        f(0);
        System.out.print(result);
    }
}