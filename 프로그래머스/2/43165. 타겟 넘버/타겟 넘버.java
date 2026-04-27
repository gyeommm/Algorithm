class Solution {
    static int answer = 0;
    static void bt(int[] numbers, int index, int sum, int target){
        if(index == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        bt(numbers, index + 1, sum - numbers[index], target);
        bt(numbers, index + 1, sum + numbers[index], target);
    }
    
    public int solution(int[] numbers, int target) {
        bt(numbers, 0, 0, target);
        return answer;
    }
}