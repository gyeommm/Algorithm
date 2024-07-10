import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++)
            q.add(-1);

        int sum = 0;
        for(int i = 0; i < truck_weights.length; answer++) {
            int out = q.poll();
            if(out != -1)
                sum -= truck_weights[out];

            if(sum + truck_weights[i] > weight){
                q.add(-1);
                continue;
            }

            q.add(i);
            sum += truck_weights[i];
            i++;
        }

        return answer + bridge_length;
    }
}