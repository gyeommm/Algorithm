import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine()) + 1;
        String binary = Integer.toBinaryString(k);

        StringBuilder result = new StringBuilder();
        for(int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result.append(7);
            } else {
                result.append(4);
            }
        }

        bw.write(result.toString());
        br.close();
        bw.flush();
    }
}