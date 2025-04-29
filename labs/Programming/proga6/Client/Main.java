/**
 * Main класс, точка входа в программу  
 * @author Alexander Sokolov
 * @version 1.0
 */
//import common.Engine.Invoker;
package Client;
public class Main {
    public static void main(String[] args) {
        ClientInvoker clientInvoker = new ClientInvoker();
        clientInvoker.console(); 
    }
}