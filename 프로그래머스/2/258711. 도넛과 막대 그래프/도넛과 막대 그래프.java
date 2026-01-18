class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];  // 정점, 도넛, 막대, 8자
        
        int[] input = new int[1000001];
        int[] output = new int[1000001];
        for(int[] edge : edges){
            output[edge[0]]++;
            input[edge[1]]++;
        }
        
        for(int i = 1; i < 1000001; i++){
            if(input[i] >= 1 && output[i] == 0){
                answer[2]++;
            }else if(input[i] >= 2 && output[i] == 2){
                answer[3]++;
            }else if(input[i] == 0 && output[i] >= 2){
                answer[0] = i;
            }
        }
        
        answer[1] = output[answer[0]] - (answer[2] + answer[3]);
        return answer;
    }
}