// 분해합

// 질문할 것 : 아래 주석 코드 처럼 시작 지점을 N의 자리수 부터 하려고 하면 틀렸다고 함

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class Java_2231 {
//     static public void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         int start = startPosition(N);
//         boolean flag=false;
//         for(int i=start-1; i<N; i++){
//             if(N == Constructor(i)){
//                 System.out.println(i);
//                 flag = true;
//                 break;
//             }
//         }
//         if(!flag)
//             System.out.println(0);
//     }

//     static public int startPosition(int N){
//         int temp=1;
//         while(N>0){
//             N/=10;
//             temp*=10;
//         }
//         return temp/10;
//     }

//     static public int Constructor(int N){
//         int temp = N;
//         while(N>0){
//             temp += (N%10);
//             N/=10;
//         }
//         return temp;
//     }
// }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2231 {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean flag=false;
        for(int i=1; i<N; i++){
            if(N == Constructor(i)){
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println(0);
    }

    static public int Constructor(int N){
        int temp = N;
        while(N>0){
            temp += (N%10);
            N/=10;
        }
        return temp;
    }
}

// 참고할만한 방법
// 함수로 구현 안하고 반복문 이용(N-1부터 1까지)

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temp = N;
        int result = 0;

        while(temp>0){
            temp--;
            int 
            while(number != 0){
                check += number%10;
                number/=10;
            }
            if(check==N) result = temp;
        }

        System.out.println(result);
    }
}