import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorNuvem {
    private static final int PORTA = 6789;

    public static void main(String[] args) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(PORTA);
            System.out.println("Servidor rodando na porta " + PORTA);
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("Cliente conectado.");
                Thread thread = new Thread(new ThreadServidor(connectionSocket));
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
        while(true){
            try {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while(true){
                    String mensagem = inFromClient.readLine();
                    System.out.println(mensagem);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
