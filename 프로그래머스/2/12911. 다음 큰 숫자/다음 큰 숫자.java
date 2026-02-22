class Solution {
    public int solution(int n) {
        int answer = n;
        
        int count = -1, prev = 0, index = 0;
        while(n > 0){
            int temp = n % 2;
            n /= 2;
            
            if(temp == 1){
                count++;
                answer -= Math.pow(2, index);
            }else if(prev == 1){
                break;
            }
            prev = temp;
            index++;
        }
        
        answer += Math.pow(2, index);
        while(--count >= 0){
            answer += Math.pow(2, count);
        }
        
        return answer;
    }
}