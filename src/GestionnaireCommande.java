import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;


public class GestionnaireCommande {

	private static GestionnaireCommande historique = null;
	private final Stack<Command> listeDeCommande;
	/**
	 * Constructeur priver du Gestionnaire de Commande. Il s'agit d'un singleton
	 */
	private GestionnaireCommande()
	{
		 listeDeCommande = new Stack<Command>();
	}
	/**
	 * Retourne l'instance du Gestionnairede Commande, s'il n'existe pas il le cree une seule
	 * fois.
	 * @return Un objet de type GestionnaireCommande
	 */
	public static GestionnaireCommande getInstance()
	{
		if(historique == null) {
	         historique = new GestionnaireCommande();
	      }
	      return historique;
	}
	/**
	 * Methode qui ajoute une commande a la pile de commande et l'Execute
	 * @param cmd La commande a executer
	 */
	public void addCommand(Command cmd)
	{
		this.listeDeCommande.add(cmd);
		cmd.execute();
	}
	/**
	 * Methode qui Defait la derniere commande qui a ete faite.
	 */
	public void Undo()
	{
		if(!this.listeDeCommande.isEmpty())
		{
			Command lastCommande = this.listeDeCommande.pop();
			lastCommande.undo();
		}
			
		
	}

	
}
