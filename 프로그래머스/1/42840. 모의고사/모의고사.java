class Solution {
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == i % 5 + 1){
                count[0]++;
            }
            if(answers[i] == p2[i % 8]){
                count[1]++;
            }
            if(answers[i] == p3[i % 10]){
                count[2]++;
            }
        }
        
        int max = Math.max(Math.max(count[0], count[1]), count[2]);
        int temp = 0;
        for(int i = 0; i < 3; i++){
            if(max == count[i]){
                temp++;
            }
        }
        
        int[] answer = new int[temp];
        temp = 0;
        for(int i = 0; i < 3; i++){
            if(max == count[i]){
                answer[temp++] = i + 1;
            }
        }
        
        return answer;
    }
}