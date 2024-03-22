import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteTaskList taskList = (RemoteTaskList) registry.lookup("TaskList");

            // Ajouter une tâche
            taskList.ajouterTache("Faire les courses");
            taskList.ajouterTache("Répondre aux emails");
            taskList.ajouterTache("Préparer le rapport");

            // Supprimer une tâche
            taskList.supprimerTache("Faire les courses");

            // Récupérer la liste complète des tâches
            List<String> listeTaches = taskList.getListeTaches();
            System.out.println("Liste des tâches :");
            for (String tache : listeTaches) {
                System.out.println(tache);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
