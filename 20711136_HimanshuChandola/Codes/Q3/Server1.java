import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

   public class Server1 {

            private static Socket socket;

            public static void main(String[] args) {
                try {
                    ServerSocket serverSocket = new ServerSocket(4000);
                    System.out.println("Server Running...");

                    while (true) {
                        
                        socket = serverSocket.accept();
                        InputStream is = socket.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String string = br.readLine();
                        System.out.println("Message received from client is " + string);
                        
                        try {
                            
                            StringBuilder input = new StringBuilder();
                            
                            input.append(string);
                            
                            input = input.reverse();
                            string = input + "\n"; 
                            for (int i = 0; i < input.length(); i++) {
                                System.out.println(input.charAt(i));
                            }
                        } catch (Exception e) {
                           
                            string = "Please send a proper text message\n";
                        }
                       
                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        BufferedWriter bw = new BufferedWriter(osw);
                        bw.write(string);
                        System.out.println("Message sent to the client is " + string);
                        bw.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (Exception e) {
                    }
                }
            }
        }