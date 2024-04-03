package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1780 {

    private static class Count{
        int minus, zero, one;
        public Count(int minus, int zero, int one){
            this.minus=minus;
            this.zero=zero;
            this.one=one;
        }

        public Count add(Count other){
            this.minus+=other.minus;
            this.zero+=other.zero;
            this.one+= other.one;

            return this;
        }

        public static Count makeCount(int flag){
            if(flag==-1) return new Count(1,0,0);
            else if(flag ==0) return new Count(0,1,0);
            else return new Count(0,0,1);
        }
    }
    private static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0;i<n;i++){
             st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Count result = recursion(n, 0,0);
        System.out.println(result.minus+"\n"
                            +result.zero+"\n"
                            +result.one);
    }

    private static Count recursion(int len, int x, int y){
        int half = len/3;
        int flag=  map[x][y];
        for(int i=x;i<len+x;i++){
            for(int j=y;j<len+y;j++){
                if(flag!= map[i][j]){
                    return
                            recursion(half, x,y)
                            .add(recursion(half, x,y+half))
                            .add(recursion(half, x,y+half*2))

                            .add(recursion(half, x+half,y))
                            .add(recursion(half, x+half,y+half))
                            .add(recursion(half, x+half,y+half*2))

                            .add(recursion(half, x+half*2,y))
                            .add(recursion(half, x+half*2,y+half))
                            .add(recursion(half, x+half*2,y+half*2));
                }
            }
        }

       return Count.makeCount(flag);
    }
}
