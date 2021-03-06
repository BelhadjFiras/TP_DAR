import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        /*String str = inServer.readLine();
        String strUpper = str.toUpperCase();
        System.out.println("The msg was " + strUpper);*/
        String msg = inServer.readLine();
        int n = Integer.parseInt(msg);
        System.out.println(n);
        for (int j=1;j<=n;j++){
            int i=2;
            while (i<=j/2){
                if (j%i==0) break;
                else i++;
            }
            if (i>j/2) System.out.println(j);
        }

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}

