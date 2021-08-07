import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

    private static Socket socket;

    public static void main(String args[]) {
        try {
            socket = new Socket("127.0.0.1", 4000);
            System.out.println("Client Running...");

            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            System.out.println("Type in a string and Press Enter...");
            Scanner sc = new Scanner(System.in);
            String string = sc.next();
            System.out.println("string = " + string);
            String sendMessage = string + "\n"; ////Next to line
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : " + sendMessage);

            
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from the server : " + message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
           
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}