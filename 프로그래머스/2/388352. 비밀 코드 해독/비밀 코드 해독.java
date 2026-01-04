import java.util.*;

class Solution {
    static List<Set<Integer>> allCase = new ArrayList<>();
    
    static void setAllCase(int n, Set<Integer> temp, int num){
        if(temp.size() == 5){
            allCase.add(new HashSet<>(temp));
            return;
        }
        
        for(int i = num; i <= n; i++){
            temp.add(i);
            setAllCase(n, temp, i + 1);
            temp.remove(i);
        }
    }
    
    static boolean isPossible(Set<Integer> set, int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int count = 0;
            for(int j = 0; j < q[i].length; j++){
                if(set.contains(q[i][j])){
                    count++;
                }
            }

            if(count != ans[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        setAllCase(n, new HashSet<>(), 1);
        
        for(int i = 0; i < allCase.size(); i++){
            if(isPossible(allCase.get(i), q, ans)){
                answer++;
            }
        }
        
        return answer;
    }
}