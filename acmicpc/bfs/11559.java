// Puyo Puyo

/*
*   연쇄 시키는 것과 다시 그리는 것을 반복하면서 갯수를 증가시켰다.
*   연쇄 시켜야 할 곳을 저장할 list를 만들어 이용하고, 다시 그리는 것에 예전에 풀었던 구슬 탈출 방법을 이용하였다.
*/

// 제출 결과: [메모리: 13236KB 시간: 80ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Java_11559 {
    static String[][] map = new String[12][6];
    static int[][] check ={{0,1}, {0,-1}, {1,0}, {-1,0}};
    static boolean[][] visit = new boolean[12][6];
    static Queue<Node> q = new LinkedList<>();
    static ArrayList<Node> chains = new ArrayList<>();
    static boolean flag = false;
    static int count = 0;

    static class Node{
        int x;
        int y;
        String ch;

        public Node(int x, int y, String ch){
            this.x = x;
            this.y = y;
            this.ch = ch;
        }
    }

    public static void bfs(String ch){
        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.x;
            int y = temp.y;

            for(int i=0; i<4; i++){
                int dx = x + check[i][0];
                int dy = y + check[i][1];

                if(0<=dx && 0<=dy && dx<12 && dy<6){
                    if(!visit[dx][dy] && ch.equals(map[dx][dy])) {
                        visit[dx][dy] = true;
                        chains.add(new Node(dx,dy,temp.ch));
                        q.add(new Node(dx,dy,temp.ch));
                    }
                }
            }
        }

    }

    public static void paint(){
        for (int i = 11; i >= 0; i--) {
            for(int j=5; j >= 0; j--){
                if(!map[i][j].equals(".")){
                    String puyo = map[i][j];
                    map[i][j] = ".";
                    int dx = i;
                    while((dx+1)<12 && map[dx+1][j].equals(".")){
                        dx++;
                    }
                    map[dx][j] = puyo;
                }
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<12; i++){
            String[] Input = br.readLine().split("");
            for(int j=0; j<6; j++){
                map[i][j] = Input[j];
            }
        }

        while(true){
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(!visit[i][j] && !map[i][j].equals(".")) {
                        visit[i][j] = true;
                        chains.add(new Node(i,j,map[i][j]));
                        q.add(new Node(i,j,map[i][j]));
                        bfs(map[i][j]);
                    }

                    if(chains.size() >= 4){
                        flag = true;
                        for (Node chain : chains)
                            map[chain.x][chain.y] = ".";
                    }
                    chains.clear();
                }
            }

            if(!flag) {
                System.out.println(count);
                break;
            }
            else {
                paint();
                for (int i = 0; i < 12; i++) {
                    Arrays.fill(visit[i], false);
                }
                flag = false;
                count++;
            }
        }
    }
}
