// 윤년

// 처음 제출 [메모리 : 12904KB 시간 : 72ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        if((year%4==0 && year%100!=0) || year%400==0)
            System.out.println(1);
        else
            System.out.println(0);
    }
}


// 또 다른 방법
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Java_2753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        int check = 0;
        if(year%4==0){
            if(year%100!=0 || year%400==0)
                check = 1;
        }
        System.out.println(check);
    }
}


