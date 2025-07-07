import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        
        boolean[] arr = new boolean[20];
        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            
            if("all".equals(s)){
                Arrays.fill(arr, true);
            }else if("empty".equals(s)){
                Arrays.fill(arr, false);
            }else{
                int n = Integer.parseInt(st.nextToken()) - 1;
                
                if("add".equals(s)){
                    arr[n] = true;
                }else if("remove".equals(s)){
                    arr[n] = false;
                }else if("check".equals(s)){
                    sb.append(arr[n] ? 1 : 0).append("\n");
                }else if("toggle".equals(s)){
                    arr[n] = !arr[n];
                }
            }
        }
        
        System.out.print(sb);
    }
}