class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
        for(int i = 0; i < players.length; i++){
            int add = (players[i] / m) - server[i];
            
            if(add > 0){
                answer += add;
                
                int end = Math.min(players.length, i + k);
                for(int j = i; j < end; j++){
                    server[j] += add;
                }
            }
        }
        
        return answer;
    }
}