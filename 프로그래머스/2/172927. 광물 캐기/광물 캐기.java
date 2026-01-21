import java.util.*;

class Solution {
    static int[] tool;
    static String[] rock;
    static Map<String, Integer> map = new HashMap<>();
    static int answer = 1250;
    
    static void bt(int now, int tired){
        if(now >= rock.length || (tool[0] == 0 && tool[1] == 0 && tool[2] == 0)){
            answer = Math.min(answer, tired);
            return;
        }
        
        for(int i = 0; i < tool.length; i++){
            if(tool[i] == 0){
                continue;
            }
            
            tool[i]--;
            int j = now;
            int temp = tired;
            int end = Math.min(now + 5, rock.length);
            for(; j < end; j++){
                StringBuilder sb = new StringBuilder(String.valueOf(i));
                temp += map.get(sb.append(rock[j]).toString());
            }
            bt(j, temp);
            tool[i]++;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        map.put("0diamond", 1);
        map.put("0iron", 1);
        map.put("0stone", 1);
        map.put("1diamond", 5);
        map.put("1iron", 1);
        map.put("1stone", 1);
        map.put("2diamond", 25);
        map.put("2iron", 5);
        map.put("2stone", 1);
        
        tool = picks;
        rock = minerals;
        bt(0, 0);
        
        return answer;
    }
}