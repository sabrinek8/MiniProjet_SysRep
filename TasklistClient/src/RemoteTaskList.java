import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteTaskList extends Remote {
    void ajouterTache(String tache) throws RemoteException;
    void supprimerTache(String tache) throws RemoteException;
    List<String> getListeTaches() throws RemoteException;
}
