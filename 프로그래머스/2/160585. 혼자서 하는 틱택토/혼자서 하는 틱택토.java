class Solution {
    static char[][] bingo = new char[3][3];
    static int[][][] winCondition = {{{0, 0}, {0, 1}, {0, 2}},
                                  {{1, 0}, {1, 1}, {1, 2}},
                                  {{2, 0}, {2, 1}, {2, 2}},
                                  {{0, 0}, {1, 0}, {2, 0}},
                                  {{0, 1}, {1, 1}, {2, 1}},
                                  {{0, 2}, {1, 2}, {2, 2}},
                                  {{0, 0}, {1, 1}, {2, 2}},
                                  {{2, 0}, {1, 1}, {0, 2}},
                                 };
    
    static boolean isWin(char c){
        for(int i = 0; i < winCondition.length; i++){
            boolean isAllEqual = true;
            
            for(int j = 0; j < winCondition[i].length; j++){
                int rr = winCondition[i][j][0];
                int cc = winCondition[i][j][1];
                
                if(bingo[rr][cc] != c){
                    isAllEqual = false;
                    break;
                }
            }
            
            if(isAllEqual){
                return true;
            }
        }
        
        return false;
    }
    
    public int solution(String[] board) {
        int answer = 1;
        
        for(int i = 0; i < board.length; i++){
            bingo[i] = board[i].toCharArray();
        }
        
        int o = 0;
        int x = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(bingo[i][j] == 'O'){
                    o++;
                }else if(bingo[i][j] == 'X'){
                    x++;
                }
            }
        }
        
        if(o < x){
            answer = 0;
        }else if(o == x){
            if(isWin('O')){
                answer = 0;
            }
        }else{
            if(o - x > 1){
                answer = 0;
            }
            if(isWin('X')){
                answer = 0;
            }
        }
        
        return answer;
    }
}