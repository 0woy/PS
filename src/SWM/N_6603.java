package SWM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_6603 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
        StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) return;

            int[] loto = new int[n];
            for (int i = 0; i < loto.length; i++) {
                loto[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[n];
            combination(loto, visited, 0, n, 6,sb);
            sb.append('\n');
        System.out.print(sb);
        }
    }

    static void combination(int [] loto, boolean[]visited, int start, int n, int r,StringBuilder sb){
        if(r==0) {
            int count =0;
            for(int j=0;j<n;j++){
                if(visited[j]){
                sb.append(loto[j]+" ");
                count++;
                }
                if(count==6) break;
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n;i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(loto, visited, i + 1, n, r - 1,sb);
                visited[i] = false;
            }
        }
    }
}
