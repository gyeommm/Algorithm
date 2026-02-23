class Solution {
    public int solution(int n) {
        int a = 1, b = 1, answer = 1;
        for(int i = 3; i <= n; i++){
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
        
        return answer;
    }
}