class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] computers, boolean[] visited, int now){
        visited[now] = true;
        
        for(int i = 0; i < computers[now].length; i++){
            if(!visited[i] && computers[now][i] == 1)
                dfs(computers, visited, i);
        }
    }
}