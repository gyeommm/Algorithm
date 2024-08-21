import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] ans = {0, 10000001};
        
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 10000001);
        
        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        
        for(int i = 0; i < paths.length; i++){
            list.get(paths[i][0]).add(new int[]{paths[i][1], paths[i][2]});
            list.get(paths[i][1]).add(new int[]{paths[i][0], paths[i][2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {     // {시간, 현위치}
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        for(int i = 0; i < gates.length; i++){
            pq.add(new int[]{0, gates[i]});
            arr[gates[0]] = 0;
        }
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            boolean check = false;
            for(int i = 0; i < summits.length; i++){
                if(now[1] == summits[i]){
                    check = true;
                    break;
                }
            }
            if(check)
                continue;
            
            if(arr[now[1]] < now[0])
                continue;
            
            for(int i = 0; i < list.get(now[1]).size(); i++){
                int[] next = new int[]{ Math.max(now[0], list.get(now[1]).get(i)[1]), list.get(now[1]).get(i)[0]};
                
                if(arr[next[1]] > next[0]){
                    pq.add(next);
                    arr[next[1]] = next[0];
                }
            }
        }

        for(int i = 0; i < summits.length; i++){
            if(ans[1] > arr[summits[i]]){
                ans[0] = summits[i];
                ans[1] = arr[summits[i]];
            }
            else if(ans[1] == arr[summits[i]])
                ans[0] = Math.min(ans[0], summits[i]);
        }
        return ans;
    }
}