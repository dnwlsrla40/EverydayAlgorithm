// 색종이 만들기

// 질문 할 것 boolean flag = false 를 if 조건문 안쪽에 넣으면 메모리가 추가되는 이유??

import java.util.Scanner;

// 처음 제출 [메모리 : 31256KB 시간 : 292ms]
public class Java_2630 {
    static int blueCount = 0; // blue == 1
    static int whiteCount = 0; // white == 0

    public static void coloredPaper(int[][] arr, int x, int y, int n){
        int check = arr[y][x];
        boolean flag = false;
        if(n==1){
            if(check == 1)
                blueCount++;
            else
                whiteCount++;
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
                coloredPaper(arr, x, y,n/2);
                coloredPaper(arr, x+(n/2), y,n/2);
                coloredPaper(arr, x,y+(n/2),n/2);
                coloredPaper(arr, x+(n/2),y+(n/2),n/2);
            } else{
                if(check == 1) {
                    blueCount++;
                } else{
                    whiteCount++;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        int[][] square;
        n = scanner.nextInt();
        square = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                square[i][j] = scanner.nextInt();
            }
        }
        coloredPaper(square,0,0,n);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
}

/*
    bufferedReader 사용[메모리 : 15416KB 시간 : 108ms]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Java_2630 {
    static int blueCount = 0; // blue == 1
    static int whiteCount = 0; // white == 0

    public static void coloredPaper(int[][] arr, int x, int y, int n){
        int check = arr[y][x];
        boolean flag = false;
        if(n==1){
            if(check == 1)
                blueCount++;
            else
                whiteCount++;
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
                coloredPaper(arr, x, y,n/2);
                coloredPaper(arr, x+(n/2), y,n/2);
                coloredPaper(arr, x,y+(n/2),n/2);
                coloredPaper(arr, x+(n/2),y+(n/2),n/2);
            } else{
                if(check == 1) {
                    blueCount++;
                } else{
                    whiteCount++;
                }
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
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                square[i][j] = Integer.parseInt(input[j]);
            }
        }
        coloredPaper(square,0,0,n);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
}
