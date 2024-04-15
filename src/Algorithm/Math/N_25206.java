package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class N_25206 {
    public static double s_sum = 0;
    public static double c_sum = 0;
    public static void calc(String credit, String score){
        double ns = 0;
        if(score.equals("P")) {
            return;
        }
        else{
            c_sum += Double.parseDouble(credit);
        switch (score){
            case "A+":  ns= 4.5;break;
            case "A0":  ns =4.0;break;
            case "B+":  ns =3.5;break;
            case "B0":  ns =3.0;break;
            case "C+":  ns =2.5;break;
            case "C0":  ns =2.0;break;
            case "D+":  ns =1.5; break;
            case "D0":  ns =1.0;break;
            case "F":   ns =0.0;break;
        }
        s_sum+= ns*Double.parseDouble(credit);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<20;i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            calc(st.nextToken(),st.nextToken());
        }
        double res = s_sum/c_sum;
        System.out.printf("%.6f",res);
    }
}
