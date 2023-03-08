import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, " + args[0]);
        double x = 0.0;
        double y = 0.0;
        try (ServerSocket server = new ServerSocket(34522)) {
            try (
                    Socket socket = server.accept();
                    DataInputStream input = new DataInputStream(socket.getInputStream());
            ){
                String msg = input.readUTF();
                x = Double.parseDouble(msg);
                msg = input.readUTF();
                y = Double.parseDouble(msg);
                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Получены значения: x = " + x + "; y = " + y);
        double result = 3 * (Math.pow((Math.cos(x - Math.PI / 6.0)),2)) / (0.5 + Math.sin(y*y));
        System.out.println(result);
    }
}
