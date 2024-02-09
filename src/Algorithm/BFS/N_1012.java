package Algorithm.BFS;

import java.io.*;
import java.util.*;

public class N_1012 {
//    static ArrayList<Integer>[] graph;
    static LinkedList<Integer> que;
    static int [][] cabbages;
    static boolean [][] visitied;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();

        for (int k = 0; k < testcase; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int hei = Integer.parseInt(st.nextToken());
            int total = Integer.parseInt(st.nextToken());

            cabbages = new int[hei + 2][len + 2];
            visitied = new boolean[hei + 2][len + 2];
            que = new LinkedList<>();
            count=0;

            for (int i = 0; i < total; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbages[hei - y][x + 1] = 1;
            }

            for (int i = 1; i <= hei; i++) {
                for (int j = 1; j <= len; j++) {
                    if (cabbages[i][j] == 1 && !visitied[i][j])
                        bfs(cabbages, i, j);
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
    static void bfs(int[][] arr, int x, int y){
        que.add(x);
        que.add(y);
        visitied[x][y] = true;
        while(que.size()!=0){
            int x1 = que.poll();
            int y1 = que.poll();
            if(!visitied[x1-1][y1]&&arr[x1-1][y1]==1 ){
                que.add(x1-1);
                que.add(y1);
                visitied[x1-1][y1]=true;
            }
            if(!visitied[x1+1][y1]&&arr[x1+1][y1]==1){
                que.add(x1+1);
                que.add(y1);
                visitied[x1+1][y1]=true;
            }
            if(!visitied[x1][y1-1]&&arr[x1][y1-1]==1){
                que.add(x1);
                que.add(y1-1);
                visitied[x1][y1-1]=true;
            }
            if(!visitied[x1][y1+1]&&arr[x1][y1+1]==1){
                que.add(x1);
                que.add(y1+1);
                visitied[x1][y1+1]=true;
            }
        }
        count++;
    }
}
