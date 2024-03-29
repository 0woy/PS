package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2630 {
    private static int[][] map;

    public static class Count{
        int zero, one;
        public Count(int zero, int one){
            this.zero=zero;
            this.one=one;
        }

        public Count add(Count other){
            this.zero+=other.zero;
            this.one+=other.one;
            return this;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        map = new int[len ][len];
        for(int i=0;i<len;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<len;j++){
                map[i][j] =Integer.parseInt(st.nextToken());
            }   // end j
        }   // end i

        StringBuilder sb=new StringBuilder();
        Count count = new Count(0,0);
        count=  recur(count, len, 0,0);
        sb.append(count.zero+"\n"+count.one);
        System.out.println(sb);
    } // end main

    public static Count recur(Count count, int len, int s_row, int s_col){
        int flag = map[s_row][s_col];
        int half = len/2;
          for(int r=s_row;r<s_row+len;r++){
              for(int c= s_col;c<s_col+len;c++) {
                  if (flag != map[r][c]) {
                   return recur(count,half, s_row,s_col)
                           .add(recur(count,half,s_row+half,s_col))
                           .add(recur(count,half,s_row,s_col+half))
                           .add(recur(count,half,s_row+half,s_col+half));
                  }
              }
            }
          if(map[s_row][s_col]==1) return new Count(0,1);
          else return new Count(1,0);
    }
}
