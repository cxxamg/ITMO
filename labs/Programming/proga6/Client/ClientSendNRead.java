package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import common.Commands.CommandResponce;
import common.Engine.ExecutionResponce;
import common.Engine.Serializer;

public class ClientSendNRead {
    public static void serializeAndSend(CommandResponce cmdRes, OutputStream os){
        byte[] serializedCmdRes = Serializer.serialize(cmdRes);
        try {
            os.write(serializedCmdRes);
        } catch (SocketException e){
            System.out.println("Сервер отключился во время отправки команды");
            System.exit(1); 
        } catch (IOException e) {
            System.out.println("Ошибка при отправлении на Client");
            System.exit(1); 
        }
    }
    
    public static void unserializeAndRead(InputStream is){
        byte[] data = new byte[20000];
        try {
            is.read(data);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении на Client");
            System.out.println("Сервер отключен");
            System.exit(1); 
        }
        Object obj = Serializer.deserialize(data);
        if (obj != null) {
            if (obj instanceof ExecutionResponce) {
                ExecutionResponce exRes = (ExecutionResponce) obj;
                System.out.println("Получен ответ от сервера: " + exRes.message());
            } else {
                System.out.println(obj.toString());
            }
        } else {
            System.out.println("Ошибка при десериализации объекта");
        }
    }
}
