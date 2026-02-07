class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int max = n / 2 + 1;
        int min = n / 2;
        int sum = max + min;
        while(min >= 1){
            if(sum == n){
                answer++;
            }
            if(sum >= n){
                sum -= max--;
            }
            sum += --min;
        }
        
        return answer;
    }
}