class Solution {
    static int answer = 0;
    
    void f(int cur, int index, int[] numbers, int target){
        if(numbers.length == index){
            if(cur == target)
                answer++;
            return;
        }
                
        f(cur + numbers[index], index + 1, numbers, target);
        f(cur - numbers[index], index + 1, numbers, target);
    }
        
    public int solution(int[] numbers, int target) {
        f(0, 0, numbers, target);
        return answer;
    }
}