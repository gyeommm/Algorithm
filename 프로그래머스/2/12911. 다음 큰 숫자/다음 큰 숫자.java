class Solution {
    public int solution(int n) {
        int answer = n, k = Integer.bitCount(n);    // 비트 1의 개수 반환
        while(Integer.bitCount(++answer) != k){}
        return answer;
    }
}