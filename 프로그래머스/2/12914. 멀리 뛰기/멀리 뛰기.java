class Solution {
    public long solution(int n) {
        long answer = 1;
        long a = 1, b = 1;
        while(--n > 0){
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
        
        return answer;
    }
}