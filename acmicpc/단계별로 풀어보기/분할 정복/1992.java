// 쿼드 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1992 {
    public static void QuadTree(int[][] arr, int x, int y, int n){
        int check = arr[y][x];
        boolean flag = false;
        if(n==1){
            if(check == 1)
                System.out.print(1);
            else
                System.out.print(0);
        } else {
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(check != arr[y+i][x+j]) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                System.out.print("(");
                QuadTree(arr, x, y,n/2);
                QuadTree(arr, x+(n/2), y,n/2);
                QuadTree(arr, x,y+(n/2),n/2);
                QuadTree(arr, x+(n/2),y+(n/2),n/2);
                System.out.print(")");
            } else{
                if(check == 1)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[][] square;
        n = Integer.parseInt(br.readLine());
        square = new int[n][n];
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<n; j++){
                square[i][j] = Integer.parseInt(input[j]);
            }
        }
        QuadTree(square,0,0,n);
    }
}
