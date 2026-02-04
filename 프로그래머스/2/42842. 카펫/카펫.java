class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int sum = brown + yellow;
        for(int i = 3; i * i <= sum; i++){
            if(sum % i != 0){
                continue;
            }
            
            answer = new int[]{Math.max(sum / i, i), Math.min(sum / i, i)};
            
            if((answer[0] - 2) * (answer[1] - 2) >= yellow){
                break;
            }
        }
        
        return answer;
    }
}