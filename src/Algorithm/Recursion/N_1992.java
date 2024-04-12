package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1992 {
    private static char [][] record;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        sb= new StringBuilder();

        int len = Integer.parseInt(br.readLine());
        record = new char[len][len];

        for(int i=0;i<len;i++){
            String tmp = br.readLine();
            for(int j=0;j<tmp.length();j++){
                record[i][j] = tmp.charAt(j);
            }
        }
        recur(len, 0,0);
        System.out.println(sb);
    }

    public static void recur(int len, int r, int c){
        if(len==1){
            sb.append(record[r][c]);
            return;
        }
        char flag = record[r][c];   // 기준
        int half= len/2;
        for(int i=r;i<r+len;i++){
            for(int j=c;j<c+len;j++){

                // 영상이 나누어지는 조건
                if(flag!=record[i][j]){
                    sb.append("(");
                    recur(half,r,c);
                    recur(half,r,c+half);
                    recur(half,r+half,c);
                    recur(half,r+half,c+half);
                    sb.append(")");
                    return;
                }
            }
        }
        // 영상이 같은 숫자로 이루어진 경우
        sb.append(flag);
    }
}
