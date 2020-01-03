// 탈출

/*
*   queue를 두개 사용하는 것이 처음이라 오류가 많았다. 처음에는 while(!S.isEmpty() && !W.isEmpty())로 했다가 
*   이렇게 해주면 중간에서 멈추는 일이 많을 꺼 같아 그냥  while(true)로 무한 루프를 돌게 했다. 물이 차오른 자리는 고슴도치가 갈 수 없으므로
*   고슴도치 queue보다 물의 queue를 먼저 탐색시켜 주었다.
*/

// 제출 결과: [메모리: 13788KB 시간: 100ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Java_3055 {
    static Queue<Node> S = new LinkedList<>();
    static Queue<Node> W = new LinkedList<>();
    static String[][] map;
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int r, c;
    static int count;

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(){
        while(true){
            count++;

            int wsize = W.size();
            for (int s = 0; s < wsize; s++) {
                Node temp = W.poll();
                int x = temp.x;
                int y = temp.y;
                for (int i = 0; i < 4; i++) {
                    int dx = x + check[i][0];
                    int dy = y + check[i][1];
                    if(0<=dx && 0<=dy && dx<r && dy<c){
                        if(map[dx][dy].equals(".")){
                            map[dx][dy] = "*";
                            W.add(new Node(dx,dy));
                        }
                    }
                }
            }

            if(S.size() == 0){
                System.out.println("KAKTUS");
                return;
            }

            int ssize = S.size();
            for (int s = 0; s < ssize; s++) {
                Node temp = S.poll();
                int x = temp.x;
                int y = temp.y;
                for (int i = 0; i < 4; i++) {
                    int dx = x + check[i][0];
                    int dy = y + check[i][1];
                    if(0<=dx && 0<=dy && dx<r && dy<c){
                        if(map[dx][dy].equals("D")) {
                            System.out.println(count);
                            return;
                        }
                        if(map[dx][dy].equals(".")){
                            map[dx][dy] = "S";
                            S.add(new Node(dx,dy));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        r = Integer.parseInt(Input[0]);
        c = Integer.parseInt(Input[1]);

        map = new String[r][c];

        for (int i = 0; i < r; i++) {
            Input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = Input[j];
                if(Input[j].equals("S"))
                    S.add(new Node(i,j));
                if(Input[j].equals("*"))
                    W.add(new Node(i,j));
            }
        }

        bfs();
    }
}
