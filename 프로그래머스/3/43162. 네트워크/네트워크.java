class Solution {
    static boolean[] isVisited = new boolean[200];
    static void dfs(int n, int[][] computers, int now){
        isVisited[now] = true;
        
        for(int i = 0; i < n; i++){
            if(computers[now][i] == 0 || isVisited[i]){
                continue;
            }
            dfs(n, computers, i);
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(computers[i][j] == 0 || isVisited[j]){
                    continue;
                }
                dfs(n, computers, j);
                answer++;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                answer++;
            }
        }
        
        return answer;
    }
}