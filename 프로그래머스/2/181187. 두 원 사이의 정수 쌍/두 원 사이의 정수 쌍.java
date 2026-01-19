class Solution {
    public long solution(int r1, int r2){
        long answer = 0;
        
        long temp1 = (long) r1 * r1;
        long temp2 = (long) r2 * r2;
        
        for(int x = r2; x > 0; x--){
            int maxY = (int)Math.sqrt(temp2 - (long)x * x);
            int minY = (int)Math.ceil(Math.sqrt(temp1 - (long)x * x));
            
            answer += maxY - minY + 1;
        }
        
        return answer * 4;
    }
}