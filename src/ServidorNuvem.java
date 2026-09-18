import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorNuvem {
    public static void main(String[] args) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6789);
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                ThreadServidor threadServidor = new ThreadServidor(connectionSocket);
                Thread thread = new Thread(threadServidor);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ThreadServidor implements Runnable{
    private Socket socket;
    ThreadServidor(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

    }

}
