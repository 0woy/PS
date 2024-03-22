package Algorithm.BFS;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
지구 온난화로 인하여 북극의 빙산이 녹고 있다.
 빙산을 그림 1과 같이 2차원 배열에 표시한다고 하자.
 빙산의 각 부분별 높이 정보는 배열의 각 칸에 양의 정수로 저장된다.
 빙산 이외의 바다에 해당되는 칸에는 0이 저장된다.

 빙산의 높이는 바닷물에 많이 접해있는 부분에서 더 빨리 줄어들기 때문에,
 배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는 일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다.
 단, 각 칸에 저장된 높이는 0보다 더 줄어들지 않는다.

 바닷물은 호수처럼 빙산에 둘러싸여 있을 수도 있다.
2차원 배열에서 동서남북 방향으로 붙어있는 칸들은 서로 연결되어 있다고 말한다.
따라서 그림 2의 빙산은 한 덩어리이지만, 그림 3의 빙산은 세 덩어리로 분리되어 있다.
 */
public class N_2573 {
    private static Ice [][] map;
    private static Queue<Ice> que = new ArrayDeque<>();
    private static final int[]dx = new int[]{0,0,-1,1};
    private static final int[]dy = new int[]{-1,1,0,0};

    private static int rest_count=0;
    private static Ice start;

    public static class Ice{
        int x, y,value,minus;
        boolean visited;

        public Ice(int x, int y, int value){
            this.x = x;
            this.y=y;
            this.value=value;
            this.minus=0;
            visited= false;
        }
    }

    public static int updateMap() {
        rest_count=0;
        boolean check = true;
        for (int i = 1; i < map.length-1; i++) {
            for (int j = 1; j < map[0].length-1; j++) {
                if (map[i][j].value > 0) {
                    map[i][j].value = Math.max(map[i][j].value - map[i][j].minus, 0);
                    if (map[i][j].value > 0) {
                        rest_count += 1;
                        map[i][j].visited = false;
                        map[i][j].minus = 0;
                        if (check) {
                            start = map[i][j];
                            map[i][j].visited = true;
                            que.offer(start);
                            check = false;
                        } // end check
                    } // end if up_map
                }   // end if map
            }// end j
        }// end i

        return rest_count;
    } // end func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        map = new Ice[row][col];
        boolean check = true;
        for(int i=0;i<row;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<col;j++){
                map[i][j] = new Ice(i,j,Integer.parseInt(st.nextToken()));
                if(map[i][j].value>0){
                    rest_count++;
                    if(check) {
                        start = map[i][j];
                        que.offer(start);
                        map[i][j].visited = true;
                        check = false;
                    }
                }
            }   // end col
        }   // end row

        int year =0;
        while(true){
            int count = bfs();
            if(count!= rest_count) break;
            rest_count = updateMap();
            if(rest_count==0){ year=0; break;}
            year +=1;
        }
        System.out.println(year);
    }   // end main

    public static int bfs(){
        int count =0;
        while(!que.isEmpty()) {
            Ice cur = que.poll();
            count+=1;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                // 배열 범위 내
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    // 빙산인 경우
                    if (!map[nx][ny].visited && map[nx][ny].value > 0){
                        map[nx][ny].visited = true;
                        que.offer(map[nx][ny]);
                    }
                    else if(map[nx][ny].value==0) {
                        cur.minus+=1;
                    }
                }   // end arr's range
            } // end d

        }
        return count;
    }
}
