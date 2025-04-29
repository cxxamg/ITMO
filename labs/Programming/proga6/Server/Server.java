package Server;
import common.Engine.Receiver;
import common.FileManager.*;
import java.io.*;
import java.net.*;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;



public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    static byte arr[] = new byte[10];
    static int len = arr.length;
    static InetAddress host; 
    static int port = 3928; 
    static SocketAddress addr; 
    static SocketChannel sock; 
    static ServerSocketChannel server;
    static boolean isServerWorking = true;

    public static void serverLaunch(){
        XmlReader.xml_read();
        //создаём отдельный поток для ввода команд save и exit
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String input = scanner.nextLine();
                if (input == null || input.isEmpty()) {
                    continue;
                }
                input = input.trim();
                switch (input) {
                    case "save" -> {Receiver.save(); logger.info("Коллекция сохранилась в XML файл");}
                    case "exit" -> {logger.info("Завершение работы сервера и сохранение коллекции в XML файл"); scanner.close(); System.exit(0);}
                    default -> logger.warning("Сервер не может выполнить данную команду: " + input);
                }
            }
        }).start();

        try (Selector selector = Selector.open()) {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));
            server.register(selector, SelectionKey.OP_ACCEPT);
    
            logger.info("Ждем подключений");
            while(isServerWorking) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                for (var iter = keys.iterator(); iter.hasNext(); ) {
                    SelectionKey key = iter.next(); iter.remove();
                    if (key.isValid()) {
                        if (key.isAcceptable()) { SelectorMethod.doAccept(key);}
                        if (key.isReadable()) {   SelectorMethod.doRead(key);} 
                        //if (key.isWritable()) { doWrite(key); }
                    }
                } 
            }
        } catch (IOException e){  
        }

    }
}
