import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteTaskList taskList = (RemoteTaskList) registry.lookup("TaskList");

            // Ajouter une t�che
            taskList.ajouterTache("Faire les courses");
            taskList.ajouterTache("R�pondre aux emails");
            taskList.ajouterTache("Pr�parer le rapport");

            // Supprimer une t�che
            taskList.supprimerTache("Faire les courses");

            // R�cup�rer la liste compl�te des t�ches
            List<String> listeTaches = taskList.getListeTaches();
            System.out.println("Liste des t�ches :");
            for (String tache : listeTaches) {
                System.out.println(tache);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
