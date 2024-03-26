package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_5427 {
    private static char [][] map;
    private static Queue<Person> person;
    private static Queue<int[]> fire;
    private static final int[] dx = new int[]{0,1,0,-1};
    private static final int[] dy = new int[]{1,0,-1,0};

    private static class Person{
        int x,y,count;
        public Person(int x, int y, int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for(int t=0;t< testcase;t++){
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            map = new char[row][col];
            fire = new ArrayDeque<>();
            person = new ArrayDeque<>();

            for(int r=0;r<row;r++){
                String str = br.readLine();
                for(int c=0;c<col;c++){
                    map[r][c]= str.charAt(c);
                    if(map[r][c]=='*'){
                        fire.offer(new int[]{r,c});
                    }
                    else if(map[r][c]=='@'){
                        person.offer(new Person(r,c,0));
                    }
                }   // end c
            }   // end r


            int res =-1;
            while (!person.isEmpty()) {
                 res = bfs();
                 if(res > 0) break;
            }
            if(res>0) sb.append(res+"\n");
            else sb.append("IMPOSSIBLE\n");
        }   // end t
        System.out.print(sb);
    }
    public static boolean checkRange(int nx, int ny){
        return nx>=0&&ny>=0&&nx<map.length&&ny<map[0].length;
    }

    public static boolean existPosition(int x, int y){
        return x==0||x==map.length-1||y==0||y==map[0].length-1;
    }
    public static int bfs(){
        int f_len = fire.size();
        int p_len = person.size();
        while (f_len-- > 0){
            int [] c_fire = fire.poll();
            for(int d=0;d<4;d++){
                int nx = c_fire[0]+dx[d];
                int ny = c_fire[1]+dy[d];

                // 배열 범위 내
                if(checkRange(nx, ny)){
                    // 빈공간인 경우
                    if(map[nx][ny]=='.' || map[nx][ny]=='@'){
                        map[nx][ny] = '*';  // 방문 처리
                        fire.offer(new int[]{nx,ny});
                    }
                }   // end arr'range
            }   // end d

        }   // end f_len
        while (p_len-- >0){
            Person cp = person.poll();
            if(existPosition(cp.x,cp.y)){
                return cp.count+1;
            }
            for(int d=0;d<4;d++){
                int nx = cp.x +dx[d];
                int ny = cp.y +dy[d];
                // 배열 범위 내
                if(checkRange(nx,ny)){
                    if(map[nx][ny]=='.'){
                        map[nx][ny] ='@';   // 방문 처리
                        person.offer(new Person(nx, ny, cp.count+1));
                    }
                }
            }
        }
        return -1;
    }
}
