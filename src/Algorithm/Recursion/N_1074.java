package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1074 {
    public static int count =0;
    public static int row, col;
    public static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2,n);

         row = Integer.parseInt(st.nextToken());
         col = Integer.parseInt(st.nextToken());
         recur(len, 0,0);
        System.out.println(count);

    }
    public static void recur(int len, int r, int c){
        if(len == 1){ return;}
        int mid = len/2;    // 0 1 2 3
        int mul = (len*len)/4;
        // 1사분면
        if(row<r+mid && col<c+mid){
            recur(mid, r,c);
        }
        // 2사분면
        else if(row<r+mid && col>=c+mid){
            count = count+mul;
            recur(mid,r,c+mid);
        }
        // 3사분면
        else if(row>=r+mid && col<c+mid){
            count = count+mul*2;
            recur(mid,r+mid,c);
        }
        // 4 사분면
        else {
            count = count+mul*3;
            recur(mid,r+mid,c+mid);
        }

    }

}
