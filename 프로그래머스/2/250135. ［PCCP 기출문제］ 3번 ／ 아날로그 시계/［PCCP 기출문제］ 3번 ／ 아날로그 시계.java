class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {        
        // 시침이랑 겹치는 경우 + 분침이랑 겹치는 경우 - 0시와 12시 정각인 경우
        
        // 시침이랑 겹치는 경우
        int c1 = h1 * 60 + m1;
        int c2 = h2 * 60 + m2;
        
        int answer = c2 - c1;
        
        double a1 = s1 * 6;     // 초침 각도
        double a2 = (h1 % 12) * 30 + (m1 * 6) / 360.0 * 30;   // 시침 각도(정밀도가 이미 더 높기 때문에 초침으로 인한 시침 각도는 계산 안함)
        if(a1 > a2){
            answer--;
        }
        
        a1 = s2 * 6;
        a2 = (h2 % 12) * 30 + (m2 * 6) / 360.0 * 30;
        if(a1 >= a2){
            answer++;
        }
        
        if(h1 < 12 && h2 >= 12){    // 정오가 되는 순간엔 1회 빼줌
            answer--;
        }
        
        // 분침이랑 겹치는 경우
        answer += c2 - c1;
        
        a1 = s1 * 6;
        a2 = m1 * 6 + (s1 * 6) / 360.0 * 6;
        if(a1 > a2){
            answer--;
        }
        
        a1 = s2 * 6;
        a2 = m2 * 6 + (s2 * 6) / 360.0 * 6;;
        if(a1 >= a2){
            answer++;
        }
        
        answer -= h2 - h1;  // 59분 -> 00분이 되는 순간마다 빼줌
        
        // 0시인 경우
        if(h1 == 0 && m1 == 0 && s1 == 0){
            answer--;
        }
        
        // 12시인 경우
        if((h1 == 12 && m1 == 0 && s1 == 0) || (h1 < 12 && h2 >= 12)){
            answer--;
        }
        
        return answer;
    }
}