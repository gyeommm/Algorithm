class Solution {
    public String solution(String s) {        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] st = s.split(" ");
        for(int i = 0; i < st.length; i++){
            int temp = Integer.parseInt(st[i]);
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(min).append(" ").append(max);
        return answer.toString();
    }
}