class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] install = new int[24];
        
        int server = 0;
        for(int i = 0; i < players.length; i++){
            if(i >= k){
                server -= install[i - k];
            }
            
            int add = (players[i] / m) - server;
            if(add > 0){
                install[i] = add;
                server += add;
                answer += add;
            }
        }
        
        return answer;
    }
}