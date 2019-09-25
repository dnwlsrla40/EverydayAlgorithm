// 크로아티아 알파벳

// if문으로 크로아티아 알파벳을 구분하여 처리하였지만 런타임 에러 발생
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Input = br.readLine();
        int count=0;
        for(int i=0; i<Input.length(); i++){
            count++;
            switch (Input.charAt(i)){
                case 'c':
                    if(i+1<Input.length() && Input.charAt(i+1) == '=' || Input.charAt(i+1) == '-')
                        i++;
                    break;
                case 'd':
                    if(i+1<Input.length() && Input.charAt(i+1) == '-')
                        i++;
                    else if(i+2<Input.length() && Input.charAt(i+1) == 'z' && Input.charAt(i+2) == '=')
                        i+=2;
                    break;
                case 'n':
                case 'l':
                    if(i+1<Input.length() && Input.charAt(i+1) == 'j')
                        i++;
                    break;
                case 's':
                case 'z':
                    if(i+1<Input.length() && Input.charAt(i+1) == '=')
                        i++;
                    break;
            }
        }
        System.out.println(count);
    }
}

// 크로아티아 알파벳으로 주어진 문자들을 포함하고 있으면 *로 변경
// 맞은 제출[메모리 : 13008KB 시간 : 84ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2941 {
    static final String[] Croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Input = br.readLine();
        for(int i=0; i<Croatia.length; i++){
            if(Input.contains(Croatia[i])){
                Input = Input.replaceAll(Croatia[i],"*");
            }
        }
        int count = Input.length();
        System.out.println(count);
    }
}
