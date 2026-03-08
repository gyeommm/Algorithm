import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        List<Integer>[] list = new ArrayList[n + 1];
        for(int[] r : roads){
            if(list[r[0]] == null){
                list[r[0]] = new ArrayList<Integer>();
            }
            if(list[r[1]] == null){
                list[r[1]] = new ArrayList<Integer>();
            }
            list[r[0]].add(r[1]);
            list[r[1]].add(r[0]);
        }
        
        int[] visit = new int[n + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{destination, 0});
        visit[destination] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(visit[now[0]] < now[1]){
                continue;
            }
            
            for(int temp : list[now[0]]){
                int[] next = {temp, now[1] + 1};
                
                if(visit[next[0]] <= next[1]){
                    continue;
                }

                pq.offer(next);
                visit[next[0]] = next[1];
            }
        }
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = visit[sources[i]] == Integer.MAX_VALUE ? -1 : visit[sources[i]];
        }
        
        return answer;
    }
}