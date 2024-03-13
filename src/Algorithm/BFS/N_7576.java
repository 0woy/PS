package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_7576 {
    private static int[][] tomato;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        tomato = new int[row][col];
        visited = new boolean[row][col];
        Queue<int[]> t_idx= new ArrayDeque<>();

        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<col;j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j]==1) {
                    t_idx.offer(new int[]{i,j});
                }
                else if(tomato[i][j]==-1) visited[i][j]=true;
            }

        }
        int day = bfs(t_idx);
        boolean [][]check = new boolean[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(check[i], true);
            if(!Arrays.equals(visited[i], check[i])){
                System.out.println(-1);
                return;
            }
        }
        int res = day==0?day:day-1;
        System.out.println(res);

    }
    private static int bfs (Queue<int[]> positon){
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};
        int max =0;
        while(!positon.isEmpty()){
            int [] tmp = positon.poll();
            visited[tmp[0]][tmp[1]] = true;

            for(int d=0;d<4;d++){
                int nx=  tmp[0]+dx[d];
                int ny=  tmp[1]+dy[d];
                if(nx>=0&&ny>=0&&nx<tomato.length&&ny<tomato[0].length){
                    if(!visited[nx][ny] && tomato[nx][ny]==0){
                        visited[nx][ny] = true;
                        tomato[nx][ny] = tomato[tmp[0]][tmp[1]]+1;
                        positon.offer(new int[]{nx,ny});
                        max = tomato[nx][ny];
                    }
                }
            }

        }
        return max;
    }
}
