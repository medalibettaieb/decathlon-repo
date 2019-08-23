package decathlon_si.services.interfaces;

import java.util.Map;

import javax.ejb.Local;
import javax.ws.rs.Path;

import decathlon_si.domaine.Produit;

@Local
@Path("/members")
public interface CommandeServiceLocal {
	void commanderParMap(Map<Produit, Integer> mapOfProduits);

	void commanderParProduit(Produit produit, Integer quantite);
}
