import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost",34522);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Who are you?");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            output.writeUTF(name);
            String receivedMsg = input.readUTF();
            System.out.println(receivedMsg);
            String msg = "";
            while (!msg.equals("bye")){
                msg = scanner.nextLine();
                output.writeUTF(msg);
                if (msg.equals("exit") && name.equals("admin"))
                    break;
                if (msg.equals("bye"))
                    break;
                receivedMsg = input.readUTF();
                System.out.println(receivedMsg);
            }
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
