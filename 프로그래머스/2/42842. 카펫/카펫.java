class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int sum = brown + yellow;
        for(int i = 3; i * i <= sum; i++){
            if(sum % i != 0){
                continue;
            }
            
            int temp = sum / i;
            if((temp - 2) * (i - 2) == yellow){
                answer = new int[]{Math.max(temp, i), Math.min(temp, i)};
            }
        }
        
        return answer;
    }
}