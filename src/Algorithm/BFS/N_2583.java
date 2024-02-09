package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class N_2583 {
    static int[][] square;
    static int height;
    static int weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();

         height=Integer.parseInt(st.nextToken());
         weight=Integer.parseInt(st.nextToken());
        int total=Integer.parseInt(st.nextToken());
        square = new int[height][weight];
        for(int i=0;i<total;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int n=y1;n<y2;n++){
                for(int m=x1;m<x2;m++)
                    square[n][m] =1;
            }
        }

        int count =0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<height;i++){
            for(int j=0;j<weight;j++){
                if(square[i][j]==0){
                    list.add(bfs(i,j));
                    count++;
                }
            }
        }
        Collections.sort(list);
        sb.append(count+"\n");
        for(int i=0;i<list.size();i++)
            sb.append(list.get(i)+" ");

        System.out.println(sb);
    }

    public static int bfs(int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i,j});
        square[i][j] = -1; // visited 대용

        int area = 1;
        int[]dx = {0,1,0,-1};
        int[]dy = {1,0,-1,0};

        while(queue.size()>0){
            int [] tmp = queue.poll();
            for(int d=0;d<4;d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];

                if(nx<0||ny<0||nx>height-1||ny>weight-1) continue;
                if(square[nx][ny]==0){
                    queue.offer(new int[]{nx,ny});
                    square[nx][ny] = -1;
                    area++;
                }
            }
        }
        return area;
    }
}
