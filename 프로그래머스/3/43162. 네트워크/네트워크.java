class Solution {
    static boolean[] isVisited;
    static void dfs(int[][] computers, int now){
        isVisited[now] = true;
        
        for(int i = 0; i < isVisited.length; i++){
            if(computers[now][i] == 0 || isVisited[i]){
                continue;
            }
            dfs(computers, i);
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(isVisited[i]){
                continue;
            }
            dfs(computers, i);
            answer++;
        }
        
        return answer;
    }
}