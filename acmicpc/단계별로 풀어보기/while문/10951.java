// A+B - 4
// 아래와 같은 방법으로 시도해 보았다.
// 로컬환경에서 재대로 실행은 되지만 백준 채점에서는 런타임에러가 발생하였다.
// 여러가지 방식으로 시도해 보다가 안되서 검색해 본 결과 Scanner 객체의 hashNextInt와 같은 메소드들을 사용해야 한다는 것을 알았다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Input = br.readLine();
        char a = Input.charAt(0);
        char b = Input.charAt(2);
        while(!Input.isEmpty()){
            System.out.println(a-'0' + b-'0');
            Input = br.readLine();
            a = Input.charAt(0);
            b = Input.charAt(2);
        }
    }
}

// 맞은 제출[메모리 : 14524KB 시간 : 140ms]
import java.io.IOException;
import java.util.Scanner;

public class Java_10951 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            System.out.println(sc.nextInt()+sc.nextInt());
        }
    }
}