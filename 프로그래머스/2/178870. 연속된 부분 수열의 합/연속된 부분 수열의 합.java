class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int min = answer[1] - answer[0];
        
        int s = 0;
        int e = 0;
        int sum = sequence[s];
        while(s <= e){
            if(sum == k && min > e - s){
                answer = new int[]{s, e};
                min = e - s;
            }
            
            if(sum <= k){
                if(e == sequence.length - 1){
                    break;
                }
                
                sum += sequence[++e];
            }else if(sum > k){
                sum -= sequence[s++];
            }            
        }
        
        return answer;
    }
}