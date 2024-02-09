package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1926 {
    static int n;
    static int m;
    static int[][] paint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         paint = new int[n][m];

         for(int i=0;i<n;i++){
             st = new StringTokenizer(br.readLine());
             for(int j=0;j<m;j++)
                 paint[i][j] =  Integer.parseInt(st.nextToken());
         }

         int max = 0;
         int count =0;
         for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 if(paint[i][j]==1){
                     count++;
                     int cur= bfs(i,j);
                     if(cur>max) max = cur;
                 }
             }
         }
         StringBuilder sb =new StringBuilder();
        sb.append(count+"\n"+max);

        System.out.println(sb);
    }

    static int bfs(int i, int j){
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i,j});
        paint[i][j] =-1;

        int[]dx ={0,1,0,-1};
        int[]dy ={1,0,-1,0};

        int area =1;
        while(que.size()>0){
            int [] tmp = que.poll();
            for(int k=0;k<4;k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];

                if(nx<0||ny<0||nx>n-1||ny>m-1) continue;

                if(paint[nx][ny]==1){
                    que.offer(new int[]{nx,ny});
                    paint[nx][ny] =-1;
                    area++;
                }
            }
        }

        return area;
    }

}

