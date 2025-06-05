import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if(s2.equals("enter")){
                set.add(s1);
            }else if(s2.equals("leave")){
                set.remove(s1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : set){
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}