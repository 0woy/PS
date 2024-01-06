package SWM;

import java.io.*;
import java.util.*;

public class N_10815 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int user = Integer.parseInt(br.readLine());
        int [] ucards =  new int[user];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<user;i++){
            ucards[i]=Integer.parseInt(st.nextToken());
        }

        int rand = Integer.parseInt(br.readLine());
        int [] rcards =  new int[rand];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<rand;i++){
            rcards[i]=Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(ucards);

        for(int i=0;i<rcards.length;i++){
            int start=0, end =user-1;
            int n = rcards[i];
            while(true){
                if(n == ucards[(start+end)/2]){
                    sb.append(1+" ");
                    break;
                }
                else if(start>end){
                    sb.append(0+" ");
                    break;
                }
                else if(n<ucards[(start+end)/2]){
                    end = (start+end)/2-1;
                }
                else{
                    start = (start+end)/2+1;
                }
            }
        }
        System.out.println(sb);
    }

}
