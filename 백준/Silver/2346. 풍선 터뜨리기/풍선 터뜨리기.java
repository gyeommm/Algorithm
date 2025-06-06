import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            dq.addLast(new int[]{i, Integer.parseInt(st.nextToken())});
        }
        
        StringBuilder sb = new StringBuilder();
        while(true){
            int[] balloon = dq.pollFirst();
            sb.append(balloon[0]).append(" ");
            
            if(dq.isEmpty()){
                break;
            }
            
            if(balloon[1] < 0){
                while(balloon[1]++ < 0){
                    dq.addFirst(dq.pollLast());
                }
            }else{
                while(--balloon[1] > 0){
                    dq.addLast(dq.pollFirst());
                }
            }
        }
        System.out.print(sb);
    }
}