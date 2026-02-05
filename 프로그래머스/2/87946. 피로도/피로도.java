class Solution {
    static int answer = -1;
    static boolean[] isVisited;
    static void f(int k, int[][] dungeons, int count){
        for(int i = 0; i < dungeons.length; i++){
            if(isVisited[i] || k < dungeons[i][0] || k < dungeons[i][1]){
                continue;
            }
            
            isVisited[i] = true;
            f(k - dungeons[i][1], dungeons, count + 1);
            isVisited[i] = false;
        }
        
        answer = Math.max(answer, count);
    }
    
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        
        f(k, dungeons, 0);
        
        return answer;
    }
}