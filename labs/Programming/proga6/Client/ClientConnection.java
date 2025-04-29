package Client;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class ClientConnection {
    public static Socket sock = null;
    public static OutputStream os = null; 
    public static InputStream is;

    public static Socket connect(String host, int port){
        //port = 3928;
        try {
            sock = new Socket(host,port);
            //sock = new Socket("helios.cs.ifmo.ru",port);
            System.out.println("Соединение установлено с Server");
        } catch (ConnectException e) {
            System.out.println("Сервер недоступен, повторите попытку позже");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка подключения к серверу");
            System.exit(1);
        }
        return sock;
    }
}
