import java.util.*;

class Solution {
    // n진수인 num을 k진수로 리턴
    static int convert(int n, int num, int k){
        // n진수를 10진수로 변환
        int decimal = 0;
        int digit = 1;

        while(num > 0){
            int temp = num % 10;
            num /= 10;

            decimal += temp * digit;
            digit *= n;
        }

        // 10진수를 k진수로 변환
        if(decimal == 0){
            return 0;
        }

        int result = 0;
        digit = 1;

        while(decimal > 0){
            result += (decimal % k) * digit;
            decimal /= k;
            digit *= 10;
        }

        return result;
    }
    
    // n진수일 때, a와 b를 연산해서 c가 나오는지 확인
    static boolean isCorrect(int n, int a, int b, int c, boolean isPlus){
        // a, b, c를 10진수로 변환
        a = convert(n, a, 10);
        b = convert(n, b, 10);
        c = convert(n, c, 10);
        
        // a, b 연산 값이 c가 맞는지 확인
        if(isPlus){
            if(a + b == c){
                return true;
            }
            return false;
        }
        
        if(a - b == c){
            return true;
        }
        return false;
    }
    
    // n진수일 때, a와 b를 연산한 결과를 10진수로 리턴
    static int calculate(int n, int a, int b, boolean isPlus){
        // a, b, c를 10진수로 변환
        a = convert(n, a, 10);
        b = convert(n, b, 10);

        if(isPlus){
            return a + b;
        }
        return a - b;
    }

    public String[] solution(String[] expressions) {
        List<String> answer = new ArrayList<>();
        
        boolean[] isPossible = new boolean[10];
        Arrays.fill(isPossible, true);
        
        // 단순 숫자만으로 가능한 진법 체크
        for(String s : expressions){
            String[] temp = s.split(" ");
            
            for(int i = 0; i < 5; i += 2){
                if("X".equals(temp[i])){
                    answer.add(s);
                    continue;
                }
            
                int one = Integer.parseInt(temp[i]) % 10;
                for(int j = 2; j <= one; j++){
                    isPossible[j] = false;
                }
            }
        }
        
        // 계산 과정으로 가능한 진법 체크
        for(String s : expressions){
            String[] temp = s.split(" ");
            if("X".equals(temp[4])){
                continue;
            }
            
            for(int i = 9; i >= 2; i--){
                if(!isPossible[i]){
                    continue;
                }
                
                isPossible[i] = isCorrect(i, Integer.parseInt(temp[0]), Integer.parseInt(temp[2]), Integer.parseInt(temp[4]), "+".equals(temp[1]));
            }
        }
        
        // X값들 채우기
        for(int i = 0; i < answer.size(); i++){
            String s = answer.get(i);
            String[] temp = s.split(" ");
            
            int prev = -1;
            for(int j = 9; j >= 2; j--){
                if(!isPossible[j]){
                    continue;
                }
                
                int result = calculate(j, Integer.parseInt(temp[0]), Integer.parseInt(temp[2]), "+".equals(temp[1]));
                result = convert(10, result, j);
                if(prev == -1){
                    prev = result;
                    s = s.replace("X", String.valueOf(result));
                    continue;
                }
                
                if(prev != result){
                    temp = s.split("=");
                    StringBuilder sb = new StringBuilder(temp[0]);
                    sb.append("= ?");
                    s = sb.toString();
                    break;
                }
            }
            
            answer.set(i, s);
        }
        
        return answer.toArray(new String[0]);
    }
}