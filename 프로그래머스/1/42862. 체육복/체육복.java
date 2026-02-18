class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        boolean[] a1 = new boolean[31];
        boolean[] a2 = new boolean[32];
        
        for(int v : reserve){
            a2[v] = true;
        }
        for(int v : lost){
            if(a2[v]){
                a2[v] = false;
                answer++;
                continue;
            }
            a1[v] = true;
        }
        
        for(int i = 1; i < 31; i++){
            if(!a1[i]){
                continue;
            }
            
            if(a2[i - 1]){
                a2[i - 1] = false;
            }else if(a2[i + 1]){
                a2[i + 1] = false;
            }else{
                continue;
            }
            answer++;
        }
        
        return answer;
    }
}