import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int max = 0;
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
        
        max = Math.max(Math.max(count[0], count[1]), count[2]);
        int size = 0;
        for(int i = 0; i < 3; i++){
            if(max == count[i]){
                size++;
            }
        }
        
        int[] answer = new int[size];
        int index = 0;
        for(int i = 0; i < 3; i++){
            if(max == count[i]){
                answer[index++] = i + 1;
            }
        }
        
        return answer;
    }
}