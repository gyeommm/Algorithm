class Solution {
    public int solution(String name) {
        int answer = 0, prev = 0, size = name.length(), min = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            char c = name.charAt(i);
            if(c == 'A'){
                continue;
            }
            
            answer += Math.min(c - 'A', 'Z' - c + 1);
            
            int temp = prev + size - i;
            min = Math.min(min, Math.min(temp + prev, temp + size - i));
            prev = i;
        }
        answer += Math.min(min, prev);
        
        return answer;
    }
}