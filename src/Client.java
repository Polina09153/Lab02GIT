import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost",34522);
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
            output.writeUTF(a);
            a = scanner.nextLine();
            output.writeUTF(a);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
