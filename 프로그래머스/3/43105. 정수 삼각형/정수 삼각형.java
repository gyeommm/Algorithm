class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        for(int i = 1; i < n; i++){
            int m = triangle[i].length;
            
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][m - 1] += triangle[i - 1][m - 2];
            for(int j = 1; j < m - 1; j++){
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        
        for(int j = 0; j < triangle[n - 1].length; j++){
            answer = Math.max(answer, triangle[n - 1][j]);
        }
        return answer;
    }
}