class Solution {
    public int solution(int n) {
        int answer = n;
        
        boolean check = true;
        int count = -1;
        int prev = -1;
        int index = -1;
        while(n > 0){
            int temp = n % 2;
            
            index++;
            if(temp == 1){
                count++;
                answer -= Math.pow(2, index);
            }else if(prev == 1){
                answer += Math.pow(2, index);
                while(--count >= 0){
                    answer += Math.pow(2, count);
                }

                break;
            }
            prev = temp;
            
            n /= 2;
        }
        
        if(answer == 0){
            answer += Math.pow(2, ++index);
            while(--count >= 0){
                answer += Math.pow(2, count);
            }
        }
        
        return answer;
    }
}