package SolvedAC.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s_count = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> card = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<s_count;i++){
            int pos = Integer.parseInt(st.nextToken());
            card.put(pos,card.getOrDefault(pos,0)+1);
        }
        int f_count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<f_count;i++){
            int pos =Integer.parseInt(st.nextToken());
            sb.append(card.getOrDefault(pos,0)+" ");
        }
        System.out.println(sb);
    }
}
