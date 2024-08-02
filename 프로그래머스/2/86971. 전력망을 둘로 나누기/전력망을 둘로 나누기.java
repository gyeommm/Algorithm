import java.util.*;

class Solution {
    static List<List<Integer>> list;
    static boolean[] visited = new boolean[101];
    static int count;

    public static void f(int now){
        visited[now] = true;
        count++;

        for(int i = 0; i < list.get(now).size(); i++){
            if(!visited[list.get(now).get(i)]){
                f(list.get(now).get(i));
            }
        }
        visited[now] = false;
    }

    public static int solution(int n, int[][] wires) {
        int answer = 100;

        for(int j = 0; j < wires.length; j++){
            list = new ArrayList<>();

            for (int i = 0; i <= n; i++)
                list.add(new ArrayList<>());

            for(int i = 0; i < wires.length; i++){
                if(i == j)
                    continue;
                list.get(wires[i][0]).add(wires[i][1]);
                list.get(wires[i][1]).add(wires[i][0]);
            }
            count = 0;
            f(1);
            answer = Math.min(answer, Math.abs(Math.abs(n - count) - count));
        }

        return answer;
    }
}