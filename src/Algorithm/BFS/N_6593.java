package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_6593 {
    static public class Point{
        private int x,y,z;
        Point(){this.x=-1;this.y=-1;this.z=-1;}
        Point(int z, int x, int y){
            this.x=x;
            this.y=y;
            this.z=z;
        }
        public void setPoint(int z, int x, int y){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            if(height==0 && row==0&& column==0) break;

            int [][][] map = new int[height][row][column];
            boolean [][][] visited = new boolean[height][row][column];
            Point start = new Point();
            Point end = new Point();

            for(int h=0;h<height;h++){
                for(int r=0;r<row;r++){
                    String str = br.readLine();
                    if(str.equals("")){
                        r-=1;
                        continue;
                    }
                    for(int c=0;c<column;c++){
                        switch (str.charAt(c)){
                            case '.':
                                map[h][r][c] = 1; break;
                            case '#':
                                map[h][r][c] = -1; break;
                            case 'S':
                                start.setPoint(h,r,c);
                                map[h][r][c] = 0; break;
                            case 'E':
                                end.setPoint(h,r,c);
                                map[h][r][c] = 1; break;
                        }
                    }
                }
            }
            int res = bfs(map,visited,start,end);
            if(res!=-1) sb.append("Escaped in ").append(res).append(" minute(s).\n");
            else sb.append("Trapped!\n");
        }
        System.out.print(sb);
    }
    static int bfs(int [][][]map, boolean visited[][][], Point start, Point goal){
        Queue<Point> que = new ArrayDeque<>();
        int [] dz = {0,0,0,0,1,-1};
        int [] dx = {1,-1,0,0,0,0}; // 우, 좌, 하, 상, 위층, 아래층
        int [] dy = {0,0,1,-1,0,0};
        visited[start.z][start.x][start.y] = true;
        que.offer(start);
        while(!que.isEmpty()){
            Point tmp = que.poll();
            for(int d=0;d<6;d++){
                int nx = tmp.x+dx[d];
                int ny = tmp.y+dy[d];
                int nz = tmp.z+dz[d];
                if(nx>=0&&ny>=0&&nz>=0&&nx<map[0].length&&ny<map[0][0].length&&nz<map.length){
                    if(!visited[nz][nx][ny] && map[nz][nx][ny]==1){
                        visited[nz][nx][ny] = true;
                        map[nz][nx][ny] = map[tmp.z][tmp.x][tmp.y]+1;
                        if(nz==goal.z&&nx==goal.x&&ny==goal.y){
                            return map[goal.z][goal.x][goal.y];
                        }
                        que.offer(new Point(nz,nx,ny));
                    }
                }
            }
        }

        return  -1;
    }
}