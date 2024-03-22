import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteTaskListImpl extends UnicastRemoteObject implements RemoteTaskList {
    private List<String> listeTaches;

    public RemoteTaskListImpl() throws RemoteException {
        listeTaches = new ArrayList<>();
    }

    public void ajouterTache(String tache) throws RemoteException {
        listeTaches.add(tache);
    }

    
    public void supprimerTache(String tache) throws RemoteException {
        listeTaches.remove(tache);
    }

    public List<String> getListeTaches() throws RemoteException {
        return new ArrayList<>(listeTaches);
    }
}
