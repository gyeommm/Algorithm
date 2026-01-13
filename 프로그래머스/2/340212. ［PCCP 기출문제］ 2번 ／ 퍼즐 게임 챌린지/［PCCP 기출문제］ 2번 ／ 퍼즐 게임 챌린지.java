class Solution {    
    public int solution(int[] diffs, int[] times, long limit) {        
        int levelMin = 1;
        int levelMax = 100000;
        int level = 0;
        long time = 0;
        
        while(levelMin < levelMax){
            level = (levelMin + levelMax) / 2;
            time = 0;
            
            for(int i = 0; i < diffs.length; i++){
                if(level >= diffs[i]){
                    time += times[i];
                }else{
                    time += (diffs[i] - level) * (times[i - 1] + times[i]) + times[i];
                }
                
                if(time > limit){
                    break;
                }
            }
            
            if(time > limit){
                levelMin = level + 1;
            }else{
                levelMax = level;
            }
        }
        
        return levelMin;
    }
}