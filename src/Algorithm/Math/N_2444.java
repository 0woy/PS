package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2444 {
    public static int blank;
    public static int star=1;
    public static StringBuilder sb;
    public static void drawStar(boolean flag){

            for (int i = 0; i < blank; i++)
                sb.append(" ");
            for (int i = 0; i < star; i++)
                sb.append("*");
            if(flag) {
                blank--;
                star += 2;
            }
            else{
                blank++;
                star-=2;
            }

        sb.append("\n");
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        blank = n-1;
        for(int i=1;i<=2*n-1;i++){
            // 삼각형
            if(i<n){
                drawStar(true);
            }
            // 역삼각형
            else{
                drawStar(false);
            }
        }
        System.out.println(sb);
    }
}
