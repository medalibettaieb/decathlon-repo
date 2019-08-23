package decathlon_si.services.impl;

import java.util.Date;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import decathlon_si.domaine.Commande;
import decathlon_si.domaine.LigneCommande;
import decathlon_si.domaine.Produit;
import decathlon_si.services.interfaces.CommandeServiceLocal;

@Stateless
public class CommandeService implements CommandeServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void commanderParMap(Map<Produit, Integer> mapOfProduits) {
		// TODO Auto-generated method stub

	}

	@Override
	public void commanderParProduit(Produit produit, Integer quantite) {
		Double numCommande = Math.random();
		LigneCommande ligneCommande = new LigneCommande(quantite,
				new Commande(numCommande.toString(), new Date(), "mag01"), produit);

		entityManager.merge(ligneCommande);

	}

}
