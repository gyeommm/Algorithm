import java.util.*;

public class Solution {
    String s;
    boolean[] visited;
    boolean[] visited2;
    boolean[] second;
    int answer = 0;

    public void f(int size, StringBuilder now){
        if (now.length() == size) {
            int num = Integer.parseInt(String.valueOf(now));
            if (second[num] && !visited[num]) {
                visited[num] = true;
                answer++;
            }

            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if(visited2[i])
                continue;

            visited2[i] = true;
            f(size, new StringBuilder(now.append(s.charAt(i))));
            visited2[i] = false;
            now = new StringBuilder(now.substring(0, now.length() - 1));
        }
    }

    public int solution(String numbers) {
        s = numbers;

        second = new boolean[(int)Math.pow(10, s.length())];
        Arrays.fill(second, true);
        second[0] = false;
        second[1] = false;

        for(int i = 2; i * i < second.length; i++){
            if(!second[i])
                continue;

            for(int j = i * i; j < second.length; j += i)
                second[j] = false;
        }

        visited = new boolean[second.length];
        for (int i = 1; i <= s.length(); i++) {
            visited2 = new boolean[s.length()];
            f(i, new StringBuilder());
        }

        return answer;
    }
}