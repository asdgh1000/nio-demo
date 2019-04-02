import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ltw
 * on 2019-04-02.
 */
public class BioExample {
    private static final int PORT_NUMBER = 8081;

    public static void main(String[] args) {
        BioExample bioExample = new BioExample();
        try {
            bioExample.server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 阻塞IO模式
     * 存在问题：
     * 效率低，一个线程需要被一直阻塞，并且一个线程只能处理一个连接。
     * @throws IOException
     */
    private void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
        Socket clientSocket = serverSocket.accept(); //线程阻塞在这边，直到有socket连接      * Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made.

        System.out.println("connection established...");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
        }
//        response = processRequest(request);
//        out.println(response);
    }
}
