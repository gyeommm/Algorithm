import java.util.*;
import java.io.*;

class Main{
    static class Point{
        long x;
        long y;

        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point p4 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        long a1 = p1.y - p2.y;
        long b1 = p2.x - p1.x;
        long c1 = -(a1 * p1.x + b1 * p1.y);

        long a2 = p3.y - p4.y;
        long b2 = p4.x - p3.x;
        long c2 = -(a2 * p3.x + b2 * p3.y);

        int result = 1;
        long temp = a1 * b2 - a2 * b1;
        if(temp == 0){      // 평행한 경우
            if(a1 == 0){    // x축 평행
                long g1 = gcd(c1, b1);
                long g2 = gcd(c2, b2);

                if((c1 / g1 != c2 / g2) || (b1 / g1 != b2 / g2)){       // y절편이 다름
                    result = 0;
                }else{
                    long max1 = Math.max(p1.x, p2.x);
                    long min1 = Math.min(p1.x, p2.x);
                    long max2 = Math.max(p3.x, p4.x);
                    long min2 = Math.min(p3.x, p4.x);

                    if(min1 > max2 || min2 > max1){
                        result = 0;
                    }
                }
            }else{          // y축 평행 or 그냥 평행
                long g1 = gcd(c1, a1);
                long g2 = gcd(c2, a2);

                if((c1 / g1 != c2 / g2) || (a1 / g1 != a2 / g2)){       // x절편이 다름
                    result = 0;
                }else{
                    long max1 = Math.max(p1.y, p2.y);
                    long min1 = Math.min(p1.y, p2.y);
                    long max2 = Math.max(p3.y, p4.y);
                    long min2 = Math.min(p3.y, p4.y);

                    if(min1 > max2 || min2 > max1){
                        result = 0;
                    }
                }
            }
        }else{              // 평행하지 않은 경우
            long x = b1 * c2 - b2 * c1;  // 교점 x좌표 분자
            long y = a2 * c1 - a1 * c2;  // 교점 y좌표 분자

            long gX = gcd(x, temp);
            x /= gX;
            long tempX = temp / gX;
            if (tempX < 0){
                x = -x;
                tempX = -tempX;
            }
        
            long gY = gcd(y, temp);
            y /= gY;
            long tempY = temp / gY;
            if (tempY < 0){
                y = -y;
                tempY = -tempY;
            }

            long max1X = Math.max(p1.x, p2.x) * tempX;
            long min1X = Math.min(p1.x, p2.x) * tempX;
            long max2X = Math.max(p3.x, p4.x) * tempX;
            long min2X = Math.min(p3.x, p4.x) * tempX;

            long max1Y = Math.max(p1.y, p2.y) * tempY;
            long min1Y = Math.min(p1.y, p2.y) * tempY;
            long max2Y = Math.max(p3.y, p4.y) * tempY;
            long min2Y = Math.min(p3.y, p4.y) * tempY;

            if (x > max1X || x > max2X || x < min1X || x < min2X ||
                    y > max1Y || y > max2Y || y < min1Y || y < min2Y) {
                result = 0;
            }
        }
        System.out.print(result);
    }
}