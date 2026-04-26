class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1000001};
        int s = 0;
        int sum = 0;
        
        for(int e = 0; e < sequence.length; e++){  
            sum += sequence[e];
            while(sum > k){
                sum -= sequence[s++];
            }
            
            if(sum == k){
                int temp = answer[1] - answer[0];
                if(temp > e - s){
                    answer[0] = s;
                    answer[1] = e;
                }
            }
        }
        
        return answer;
    }
}