package SWM;

import java.io.*;
import java.util.StringTokenizer;

public class N_1924 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String [] week =new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int totalDays=0;
        for(int i=1;i<month;i++){
            switch (i){
                case 2:
                    totalDays+=28;
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    totalDays+=31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    totalDays+=30;
                    break;
            }
        }

        totalDays+=day;
        System.out.println(week[totalDays%7]);

    }
}
