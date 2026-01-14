import java.util.*;

class Solution {
    static int answer = 0;
    static int time = 0;
    static Map<Integer, Boolean>[][] record = new HashMap[101][101];
    
    static void move(int[] now, int[] destination, int num){
        for(; now[num] != destination[num]; time++){
            if(isCrashed(now)){
                answer++;
            }

            if(destination[num] > now[num]){
                now[num]++;
            }else{
                now[num]--;
            }
        }
    }
    
    static boolean isCrashed(int[] now){
        if(record[now[0]][now[1]] == null){
            record[now[0]][now[1]] = new HashMap<>();
        }

        Boolean isCrashed = record[now[0]][now[1]].get(time);
        if(isCrashed == null){
            record[now[0]][now[1]].put(time, false);
        }else if(!isCrashed){
            record[now[0]][now[1]].put(time, true);
            return true;
        }
        
        return false;
    }

    public int solution(int[][] points, int[][] routes) {
        for(int i = 0; i < routes.length; i++){
            int start = routes[i][0] - 1;
            int[] now = points[start].clone();
            
            time = 0;
            for(int j = 1; j < routes[i].length; j++){
                int end = routes[i][j] - 1;
                int[] destination = points[end];

                move(now, destination, 0);
                move(now, destination, 1);
            }
            
            if(isCrashed(now)){
                answer++;
            }
        }
        
        return answer;
    }
}