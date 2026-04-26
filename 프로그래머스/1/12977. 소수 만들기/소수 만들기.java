import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] isPrime;
    
    static public void bt(int[] nums, int now, int sum, int count){
        if(count == 3){
            if(isPrime[sum]){
                answer++;
            }
            return;
        }
        
        for(int i = now + 1; i < nums.length; i++){
            bt(nums, i, sum + nums[i], count + 1);
        }
    }
    
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        
        isPrime = new boolean[nums[l - 1] + nums[l - 2] + nums[l - 3] + 1];
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i * i < isPrime.length; i++){
            if(!isPrime[i]){
                continue;
            }
            
            for(int j = i * i; j < isPrime.length; j += i){
                isPrime[j] = false;
            }
        }
        
        bt(nums, -1, 0, 0);
        
        return answer;
    }
}