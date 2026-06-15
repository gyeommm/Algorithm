class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;
        
        while(a != b){
            a = (a + a % 2) / 2;
            b = (b + b % 2) / 2;
            answer++;
        }
        
        return answer;
    }
}