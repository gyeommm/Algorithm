class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        for(int i = 1; i < n; i++){
            int m = triangle[i].length;
            for(int j = 0; j < m; j++){
                if(j == 0){
                    triangle[i][j] += triangle[i - 1][j];
                }else if(j == m - 1){
                    triangle[i][j] += triangle[i - 1][j - 1];
                }else{
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }
        
        for(int j = 0; j < triangle[n - 1].length; j++){
            answer = Math.max(answer, triangle[n - 1][j]);
        }
        return answer;
    }
}