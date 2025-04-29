package Server;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;
import common.Commands.CommandResponce;
import common.Engine.CommandHistory;
import common.Engine.Serializer;

public class SelectorMethod {
    private static final Logger logger = Logger.getLogger(SelectorMethod.class.getName());

     public static void doAccept(SelectionKey key) throws IOException{
        var ssc = (ServerSocketChannel) key.channel();
        var sc = ssc.accept();
        logger.info("Подключение найдено");
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ);
      }

    public static void doRead(SelectionKey key) throws IOException {
        var sc = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(2000);
    
        int bytesRead = sc.read(buffer); // читаем данные в буфер
        if (bytesRead == -1) {
            logger.info("Клиент отключился");
            sc.close();
            key.cancel();
            return;
        }
    
        buffer.flip(); // переходим в режим чтения
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data); // читаем байты из буфера
    
        Object obj = Serializer.deserialize(data);
        if (obj != null) {
            logger.info("Получен объект: " + obj.toString());
            if (obj instanceof CommandResponce) {
                CommandResponce cmdRes = (CommandResponce) obj;
                CommandHistory.addCommandToHistory(cmdRes.cmd.getCmdName());
                switch (cmdRes.typeOfCmdResponce){
                    case 0 -> {sc.register(key.selector(), SelectionKey.OP_WRITE); doWrite(key, cmdRes.cmd.execute(cmdRes.city, "-1"));logger.info("Отправляем результат для case 0");}//add
                    case 1 -> {sc.register(key.selector(), SelectionKey.OP_WRITE); doWrite(key, cmdRes.cmd.execute());logger.info("Отправляем результат для case 1");} //команды без аругмента
                    case 2 -> {sc.register(key.selector(), SelectionKey.OP_WRITE); doWrite(key, cmdRes.cmd.execute(cmdRes.city, cmdRes.value));logger.info("Отправляем результат для case 2");} //update, insert_at
                    case 3 -> {sc.register(key.selector(), SelectionKey.OP_WRITE); doWrite(key, cmdRes.cmd.execute(cmdRes.value)); logger.info("Отправляем результат для case 3");} //команды с аргументом
                }
            }
        } else {
            logger.warning("Ошибка при десериализации объекта");
        }
    
        // sc.register(key.selector(), SelectionKey.OP_WRITE); doWrite(key, "ds");
    }
    
    
    public static void doWrite(SelectionKey key, Object obj) throws IOException{
            var sc = (SocketChannel) key.channel();
            byte[] data = Serializer.serialize(obj);
            ByteBuffer buf = ByteBuffer.wrap(data);
            try {
                int written = sc.write(buf);
                if (written == 0) {
                    logger.info("Ничего не записано, возможно клиент не готов.");
                }
                key.interestOps(SelectionKey.OP_READ); 
            } catch (IOException e) {
                logger.info("Клиент отключился");
                try {
                    key.cancel();     // отменяем ключ
                    sc.close();       // закрываем соединение
                } catch (IOException ex) {
                    logger.warning("Ошибка при закрытии канала");
                }
            }
        }
}
