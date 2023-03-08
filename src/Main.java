import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сервер запущен и готов к работе...");
        boolean f = true;
        try (ServerSocket server = new ServerSocket(34522)) {
            while (f) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String name = input.readUTF();
                    System.out.println("К нам пришел " + name);
                    String answer = "Hello, " + name;
                    output.writeUTF(answer);
                    int k = 1;
                    String msg = "";
                    while (!msg.equals("bye")){
                        msg = input.readUTF();
                        if (name.equals("admin") && msg.equals("exit")){
                            f = false;
                            break;
                        }
                        if (msg.equals("bye"))
                            break;
                        System.out.println("Получено сообщение №" + k + " - " + msg);
                        msg = "Ответ сервера " + k + " - " + msg;
                        output.writeUTF(msg);
                        k += 1;
                    }
                    System.out.println("Пока, " + name);
                    input.close();
                    output.close();
                }
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
