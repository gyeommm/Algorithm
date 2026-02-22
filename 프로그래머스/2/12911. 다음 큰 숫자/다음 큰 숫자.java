class Solution {
    public int solution(int n) {
        int answer = n;
        int k = Integer.bitCount(n);    // 비트 1의 개수 반환
        
        while(++answer > 0){
            if(Integer.bitCount(answer) == k){
                break;
            }
        }
        
        return answer;
    }
}