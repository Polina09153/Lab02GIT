import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, " + args[0]);
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double result = 3 * (Math.pow((Math.cos(x - Math.PI / 6.0)),2)) / (0.5 + Math.sin(y*y));
        System.out.println(result);
    }
}