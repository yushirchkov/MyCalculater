import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("������� ���������:");
        Scanner console = new Scanner(System.in);

        Calculater calculater = new Calculater();


        try {
            final String result = calculater.calculate(console.nextLine());
            System.out.println("���������: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        console.close();

    }

}
