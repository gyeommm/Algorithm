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
        int[] visited = new int[edge.length + 1];
        q.offer(new int[]{1, 0});
        visited[1] = 1;
        
        int depthMax = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            depthMax = Math.max(depthMax, now[1]);
            
            for(int i = 0; i < list.get(now[0]).size(); i++){
                int[] next = new int[]{list.get(now[0]).get(i), now[1] + 1};
                if(visited[next[0]] > 0){
                    continue;
                }
                
                q.offer(next);
                visited[next[0]] = next[1];
            }
        }
        
        for(int i = 1; i < visited.length; i++){
            if(visited[i] == depthMax){
                answer++;
            }
        }
        
        return answer;
    }
}