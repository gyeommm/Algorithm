import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Map<Integer, Boolean>[][] record = new HashMap[101][101];
        
        for(int i = 0; i < routes.length; i++){
            int start = routes[i][0] - 1;
            int[] now = points[start].clone();
            
            int time = 0;
            for(int j = 1; j < routes[i].length; j++){
                int end = routes[i][j] - 1;
                int[] destination = points[end];

                for(; now[0] != destination[0]; time++){
                    if(record[now[0]][now[1]] == null){
                        record[now[0]][now[1]] = new HashMap<>();
                    }

                    Boolean isCrashed = record[now[0]][now[1]].get(time);
                    if(isCrashed == null){
                        record[now[0]][now[1]].put(time, false);
                    }else if(!isCrashed){
                        record[now[0]][now[1]].put(time, true);
                        answer++;
                    }

                    if(destination[0] > now[0]){
                        now[0]++;
                    }else{
                        now[0]--;
                    }
                }

                for(; now[1] != destination[1]; time++){
                    if(record[now[0]][now[1]] == null){
                        record[now[0]][now[1]] = new HashMap<>();
                    }

                    Boolean isCrashed = record[now[0]][now[1]].get(time);
                    if(isCrashed == null){
                        record[now[0]][now[1]].put(time, false);
                    }else if(!isCrashed){
                        record[now[0]][now[1]].put(time, true);
                        answer++;
                    }

                    if(destination[1] > now[1]){
                        now[1]++;
                    }else{
                        now[1]--;
                    }
                }
            }
            
            if(record[now[0]][now[1]] == null){
                record[now[0]][now[1]] = new HashMap<>();
            }

            Boolean isCrashed = record[now[0]][now[1]].get(time);
            if(isCrashed == null){
                record[now[0]][now[1]].put(time, false);
            }else if(!isCrashed){
                record[now[0]][now[1]].put(time, true);
                answer++;
            }
        }
        
        return answer;
    }
}