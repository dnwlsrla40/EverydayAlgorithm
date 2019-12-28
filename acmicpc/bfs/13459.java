// 노드 통합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[][] map;
    static boolean[][][][] visit;
    static int n,m;
    static Queue<Node> q = new LinkedList<>();
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int end_x, end_y;
    static boolean flag;

    static class Node{
        int r_x;
        int r_y;

        int b_x;
        int b_y;
        int count;

        public Node(int r_x, int r_y, int b_x, int b_y, int count){
            this.r_x = r_x;
            this.r_y = r_y;
            this.b_x = b_x;
            this.b_y = b_y;
            this.count = count;
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Node temp = q.poll();
            int rx = temp.r_x;
            int ry = temp.r_y;
            int bx = temp.b_x;
            int by = temp.b_y;

            if(rx==end_x && ry==end_y) {
                if(temp.count <= 10) {
                    flag = true;
                    break;
                }
            }

            for (int i = 0; i < 4; i++) {
                int r_dx = rx;
                int r_dy = ry;
                int b_dx = bx;
                int b_dy = by;
                while(!map[r_dx+check[i][0]][r_dy+check[i][1]].equals("#") && !map[r_dx][r_dy].equals("O")){
                    r_dx += check[i][0];
                    r_dy += check[i][1];
                }
                while(!map[b_dx+check[i][0]][b_dy+check[i][1]].equals("#") && !map[b_dx][b_dy].equals("O")){
                    b_dx += check[i][0];
                    b_dy += check[i][1];
                }

                if(b_dx==end_x && b_dy==end_y) {
                    continue;
                }

                if(r_dx == b_dx && r_dy == b_dy){
                    if(i==0){
                        if(rx>bx) r_dx+=1;
                        else b_dx+=1;
                    }else if(i == 1){
                        if(rx>bx) b_dx-=1;
                        else r_dx-=1;
                    }else if(i == 2){
                        if(ry>by) r_dy+=1;
                        else b_dy+=1;
                    } else{
                        if(ry>by) b_dy-=1;
                        else r_dy-=1;
                    }
                }
                if(!visit[r_dx][r_dy][b_dx][b_dy]){
                    q.add(new Node(r_dx,r_dy,b_dx,b_dy,temp.count+1));
                    visit[r_dx][r_dy][b_dx][b_dy] = true;

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] Input = br.readLine().split(" ");

        n = Integer.parseInt(Input[0]);
        m = Integer.parseInt(Input[1]);

        map = new String[n][m];
        visit = new boolean[n][m][n][m];

        int r_x=0, r_y=0, b_x=0, b_y=0;

        for (int i = 0; i < n; i++) {
            Input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Input[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j].equals("R")){
                    r_x = i;
                    r_y = j;
                } else if(map[i][j].equals("B")){
                    b_x = i;
                    b_y = j;
                } else if(map[i][j].equals("O")){
                    end_x = i;
                    end_y = j;
                }
            }
        }

        visit[r_x][r_y][b_x][b_y]=true;
        q.add(new Node(r_x, r_y,b_x,b_y,0));
        bfs();

        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}


// 노드 분리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Java_13459 {
    static String[][] map;
    static boolean[][][][] visit;
    static int n,m;
    static Queue<Node> r_q = new LinkedList<>();
    static Queue<Node> b_q = new LinkedList<>();
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int end_x, end_y;
    static boolean flag;

    static class Node{
        int x;
        int y;
        int count;

        public Node(int r_x, int r_y, int count){
            this.x = r_x;
            this.y = r_y;
            this.count = count;
        }
    }

    public static void bfs(){
        while(!r_q.isEmpty() && !b_q.isEmpty()){
            Node r_temp = r_q.poll();
            int rx = r_temp.x;
            int ry = r_temp.y;

            Node b_temp = b_q.poll();
            int bx = b_temp.x;
            int by = b_temp.y;

            if(rx==end_x && ry==end_y) {
                if(r_temp.count <= 10) {
                    flag = true;
                    break;
                }
            }

            for (int i = 0; i < 4; i++) {
                int r_dx = rx;
                int r_dy = ry;
                int b_dx = bx;
                int b_dy = by;
                while(!map[r_dx+check[i][0]][r_dy+check[i][1]].equals("#") && !map[r_dx][r_dy].equals("O")){
                    r_dx += check[i][0];
                    r_dy += check[i][1];
                }
                while(!map[b_dx+check[i][0]][b_dy+check[i][1]].equals("#") && !map[b_dx][b_dy].equals("O")){
                    b_dx += check[i][0];
                    b_dy += check[i][1];
                }

                if(b_dx==end_x && b_dy==end_y) {
                    continue;
                }

                if(r_dx == b_dx && r_dy == b_dy){
                    if(i==0){
                        if(rx>bx) r_dx+=1;
                        else b_dx+=1;
                    }else if(i == 1){
                        if(rx>bx) b_dx-=1;
                        else r_dx-=1;
                    }else if(i == 2){
                        if(ry>by) r_dy+=1;
                        else b_dy+=1;
                    } else{
                        if(ry>by) b_dy-=1;
                        else r_dy-=1;
                    }
                }
                if(!visit[r_dx][r_dy][b_dx][b_dy]){
                    r_q.add(new Node(r_dx,r_dy,r_temp.count+1));
                    b_q.add(new Node(b_dx,b_dy,0));
                    visit[r_dx][r_dy][b_dx][b_dy] = true;

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] Input = br.readLine().split(" ");

        n = Integer.parseInt(Input[0]);
        m = Integer.parseInt(Input[1]);

        map = new String[n][m];
        visit = new boolean[n][m][n][m];

        int r_x=0, r_y=0, b_x=0, b_y=0;

        for (int i = 0; i < n; i++) {
            Input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Input[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j].equals("R")){
                    r_x = i;
                    r_y = j;
                } else if(map[i][j].equals("B")){
                    b_x = i;
                    b_y = j;
                } else if(map[i][j].equals("O")){
                    end_x = i;
                    end_y = j;
                }
            }
        }

        visit[r_x][r_y][b_x][b_y]=true;
        r_q.add(new Node(r_x, r_y,0));
        b_q.add(new Node(b_x, b_y,0));
        bfs();

        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}
