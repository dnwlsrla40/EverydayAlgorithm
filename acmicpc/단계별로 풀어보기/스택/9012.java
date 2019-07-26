import java.util.Scanner;

public class Java_9012 {
   public static void check(String bracket){
        int count=0;
        for(int i=0; i<bracket.length(); i++){
            if(bracket.toCharArray()[i]=='(')
                count++;
            else
                count--;
            if(count<0) {
                System.out.println("NO");
                return;
            }
        }
        if(count==0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String bracket_list[] = new String[count+1];
        for(int i = 1; i <= count; i++) {
            bracket_list[i] = scanner.next();
        }
        for (int i = 1; i <= count; i++) {
            check(bracket_list[i]);
        }
    }
}
