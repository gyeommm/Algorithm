import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= edge.length; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[edge.length + 1];
        
        q.offer(new int[]{1, 0});
        visited[1] = true;
        
        int depth = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[1] > depth){
                depth = now[1];
                answer = 1;
            }else{
                answer++;
            }
            
            for(int i = 0; i < list.get(now[0]).size(); i++){
                int next = list.get(now[0]).get(i);
                if(visited[next]){
                    continue;
                }
                
                q.offer(new int[]{next, now[1] + 1});
                visited[next] = true;
            }
        }
        
        return answer;
    }
}