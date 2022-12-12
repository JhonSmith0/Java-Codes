import java.util.Scanner;

public class Questionario {
    static Scanner sc = new Scanner(System.in);    

    public void closeScanner() {
        sc.close();
    }


    public String ask (String title) {
        System.out.print(title);
        String answer = sc.nextLine().trim();
        return answer;
    }

    public int ask (String title, Boolean inteiro) {
        System.out.print(title);
        int answer = sc.nextInt();
        sc.nextLine();
        return answer;
    }

    
}
