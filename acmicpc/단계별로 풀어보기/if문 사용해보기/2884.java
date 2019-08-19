// 알람 시계


// 처음 제출 [메모리 : 12964KB 시간 : 76ms]
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Java_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        int hour = Integer.parseInt(Input[0]);
        int min = Integer.parseInt(Input[1]);

        System.out.println(min >= 45 ? hour +" "+ (min-45) : hour==0 ? (hour+23) + " " + (min+15) :(hour-1) + " " + (min+15));
    }
}

