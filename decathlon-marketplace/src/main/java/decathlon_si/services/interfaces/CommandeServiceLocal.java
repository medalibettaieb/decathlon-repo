package decathlon_si.services.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ws.rs.Path;

import decathlon_si.domaine.Commande;
import decathlon_si.domaine.Produit;
import decathlon_si.domaine.User;

@Local
@Path("/members")
public interface CommandeServiceLocal {
	void commanderParMap(Map<Produit, Integer> mapOfProduits, User client);

	void commanderParProduit(Produit produit, Integer quantite);

	List<Commande> findCommandesByUser(int id);
}
