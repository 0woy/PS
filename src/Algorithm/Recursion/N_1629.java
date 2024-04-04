package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long pow = Long.parseLong(st.nextToken());
        long div = Long.parseLong(st.nextToken());
        System.out.println(mul(n,pow,div));

    }

    public static long mul(long n,long pow, long div){
        if(pow==1) return n%div;
        long tmp = mul(n, pow/2, div);
        if(pow%2==1) {
            return (tmp*tmp%div)* n%div;
        }
        return tmp*tmp %div;
    }

}
