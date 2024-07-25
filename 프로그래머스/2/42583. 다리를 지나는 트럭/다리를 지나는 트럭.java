import java.util.*;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        // queue의 값을 0으로 다 초기화
        for(int i = 0; i < bridge_length; i++)
            q.add(0);
        
        for(int i = 0; i < truck_weights.length; i++) {
            
            sum -= q.poll();
            if (sum + truck_weights[i] > weight) {
                q.add(0);
                i--;
            }else { //더 들어갈 수 있는 경우
                q.add(truck_weights[i]);
                sum += truck_weights[i];
            }
            time++;
        }
        return time + bridge_length;
    }
}