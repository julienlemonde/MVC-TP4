import java.awt.List;
import java.util.ArrayList;


public class GestionnaireCommande {

	private static GestionnaireCommande historique = null;
	private final ArrayList<Command> listeDeCommande;
	private GestionnaireCommande()
	{
		 listeDeCommande = new ArrayList<Command>();
	}
	
	public static GestionnaireCommande getInstance()
	{
		if(historique == null) {
	         historique = new GestionnaireCommande();
	      }
	      return historique;
	}
	
	public void addCommand(Command cmd)
	{
		this.listeDeCommande.add(cmd);
		cmd.execute();
	}

	
}
