package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_7569 {
    private static int[][][] box;
    private static boolean[][][] visited;
    private static Queue<int[]> position = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row  = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        box =new int[height][row][col];
        visited =new boolean[height][row][col];

        for(int h=0;h<height;h++){
            for(int r=0;r<row;r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0;c<col;c++){
                    box[h][r][c] =  Integer.parseInt(st.nextToken());
                    switch(box[h][r][c]){
                        case 1:
                            position.offer(new int[]{h,r,c});
                            break;
                        case -1:
                            visited[h][r][c] = true;
                            break;
                    } // end switch

                }// end c loop
            } // end r loop
        }// end h loop

        int day = bfs();
        boolean [][][] check = new boolean[height][row][col];
        for(int h=0;h<height;h++) {
            for(int r=0;r<row;r++) {
                Arrays.fill(check[h][r], true);
                if (!Arrays.equals(visited[h][r], check[h][r])) {
                    System.out.println(-1);
                    return;
                } // end if loop
            } // end r loop
        } // end h loop

        int res = day==0?0:day-1;
        System.out.println(res);
    } // end main

    public static int bfs(){
        int [] dx = {0,1,0,-1,0,0};
        int [] dy = {1,0,-1,0,0,0};
        int [] dh = {0,0,0,0,1,-1}; // 상, 우, 하, 좌, 위, 아래
        int max =0; // day count

        while(!position.isEmpty()){
            int [] tmp = position.poll();
            int ch = tmp[0];
            int cx = tmp[1];
            int cy = tmp[2];
            visited[ch][cx][cy] = true;
            for(int d=0;d<6;d++){
                int nh = ch + dh[d];
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                // 배열 범위를 초과하지 않은 경우
                if(nh>=0 &&nx>=0 &&ny>=0
                        && nh<box.length &&nx<box[0].length &&ny<box[0][0].length){
                    if(box[nh][nx][ny]==0 &&!visited[nh][nx][ny]){
                        visited[nh][nx][ny]=true;
                        position.offer(new int[]{nh,nx,ny});
                        box[nh][nx][ny]= box[ch][cx][cy]+1 ;
                        max = (max < box[nh][nx][ny]) ? box[nh][nx][ny]: max;
                    } // end box & visited loop
                } // end array bound loop

            } // end d loop
        } // end while loop

        return max;
    }
}
