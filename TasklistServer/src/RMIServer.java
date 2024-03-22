import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            RemoteTaskList taskList = new RemoteTaskListImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("TaskList", taskList);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
