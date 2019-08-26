package decathlon_si.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import decathlon_si.domaine.Commande;
import decathlon_si.domaine.LigneCommande;
import decathlon_si.domaine.Produit;
import decathlon_si.domaine.User;
import decathlon_si.services.interfaces.CommandeServiceLocal;

@Stateless
public class CommandeService implements CommandeServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void commanderParMap(Map<Produit, Integer> mapOfProduits, User client) {
		Commande commande = new Commande(Double.toString(Math.random()), new Date(), "Mag01");
		commande.setUser(client);
		entityManager.persist(commande);
		entityManager.flush();

		System.out.println(commande.getId());
		for (Map.Entry<Produit, Integer> entry : mapOfProduits.entrySet()) {
			Produit key = entry.getKey();
			Integer value = entry.getValue();

			LigneCommande ligneCommande = new LigneCommande(value, commande, key);
			entityManager.merge(ligneCommande);
		}

	}

	@Override
	public void commanderParProduit(Produit produit, Integer quantite) {
		Double numCommande = Math.random();
		LigneCommande ligneCommande = new LigneCommande(quantite,
				new Commande(numCommande.toString(), new Date(), "mag01"), produit);

		entityManager.merge(ligneCommande);

	}

	@Override
	public List<Commande> findCommandesByUser(int id) {
		return entityManager.createQuery("select a from Commande a where a.user.id=:p").setParameter("p", id)
				.getResultList();
	}

}
