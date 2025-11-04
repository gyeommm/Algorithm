class Solution {
    public int[] solution(int m, int n, int x, int y, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++){
            int X = balls[i][0];
            int Y = balls[i][1];
            
            answer[i] = Integer.MAX_VALUE;
            int a, b, c;
            
            if(y != Y){
                // y축 원쿠션
                a = Math.abs(y - Y);
                b = x + X;
                c = (int)(Math.pow(a, 2) + Math.pow(b, 2));
                
                answer[i] = Math.min(answer[i], c);
            
                // y축 맞은편 원쿠션
                b = (m - x) + (m - X);
                c = (int)(Math.pow(a, 2) + Math.pow(b, 2));
                
                answer[i] = Math.min(answer[i], c);
            }else{
                if(x < X){
                    answer[i] = Math.min(answer[i], (int)Math.pow(x + X, 2));
                }else{
                    answer[i] = Math.min(answer[i], (int)Math.pow((m - x) + (m - X), 2));
                }
            }
            
            if(x != X){
                // x축 원쿠션
                a = Math.abs(x - X);
                b = y + Y;
                c = (int)(Math.pow(a, 2) + Math.pow(b, 2));
                
                answer[i] = Math.min(answer[i], c);
            
                // x축 맞은편 원쿠션
                b = (n - y) + (n - Y);
                c = (int)(Math.pow(a, 2) + Math.pow(b, 2));
                
                answer[i] = Math.min(answer[i], c);
            }else{
                if(y < Y){
                    answer[i] = Math.min(answer[i], (int)Math.pow(y + Y, 2));
                }else{
                    answer[i] = Math.min(answer[i], (int)Math.pow((n - y) + (n - Y), 2));
                }
            }
        }
        
        return answer;
    }
}