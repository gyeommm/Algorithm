import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int now = Integer.parseInt(st.nextToken());
            
            while(!dq.isEmpty() && dq.peekLast()[0] >= now){
                dq.pollLast();
            }
            dq.offerLast(new int[]{now, i});
            
            if(dq.peekFirst()[1] <= i - l){
                dq.pollFirst();
            }
            sb.append(dq.peekFirst()[0]).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}