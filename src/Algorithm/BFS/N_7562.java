package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_7562 {
    static int n;
    static boolean [][] visited;
    static int [][] board;
    static int cx,cy,gx,gy;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int k=0;k<testcase;k++){
            n = Integer.parseInt(br.readLine());
            visited=new boolean[n][n];
            board=new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            gx = Integer.parseInt(st.nextToken());
            gy = Integer.parseInt(st.nextToken());
            visited[cx][cy]=true;
            board[cx][cy]=0;
            bfs(cx,cy);
            sb.append(board[gx][gy]+"\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int i,int j){
        // (-2,-1), (-2,+1), (-1,-2), (-1,2)
        // (2,-1), (2,1)
        int dx[] = {-2,2,-1,1};
        int dy[] = {-1,1,-2,2};
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i,j});
        while (!que.isEmpty()){
            int [] tmp = que.poll();
            if(tmp[0]==gx && tmp[1]==gy) break;
            for(int k=0;k<4;k++){
                for(int d=0;d<2;d++){
                    int nx = tmp[0]+dx[k];
                    int ny = (k<2)?tmp[1]+dy[d]:tmp[1]+dy[3-d];
                    if(nx>=0&&ny>=0&&nx<n&&ny<n){
                        if(!visited[nx][ny]){
                            visited[nx][ny]= true;
                            board[nx][ny] = board[tmp[0]][tmp[1]]+1;
                            que.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
    }
}
